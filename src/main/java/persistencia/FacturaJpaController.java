package persistencia;

import logica.Factura;
import logica.DetalleFactura;
import logica.Cliente;
import logica.Empleado;
import logica.Descuento;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;
import java.util.List;
import javax.persistence.Persistence;
import persistencia.exceptions.NonexistentEntityException;

public class FacturaJpaController implements Serializable {

    public FacturaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public FacturaJpaController() {
        emf = Persistence.createEntityManagerFactory("MinimarketfinalPU");
    }

    public void create(Factura factura) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(factura);
            for (DetalleFactura detalle : factura.getDetalles()) {
                detalle.setFactura(factura); // Set the reference back to the factura
                em.persist(detalle);
            }
            em.getTransaction().commit();
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            em.close();
        }
    }

    public void edit(Factura factura) throws NonexistentEntityException, Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            factura = em.merge(factura);

            // Handle DetalleFactura update
            for (DetalleFactura detalle : factura.getDetalles()) {
                if (detalle.getId() == 0) {
                    em.persist(detalle);
                } else {
                    em.merge(detalle);
                }
            }

            em.getTransaction().commit();
        } catch (Exception ex) {
            Integer id = factura.getId();
            if (findFactura(id) == null) {
                throw new NonexistentEntityException("The factura with id " + id + " no longer exists.");
            }
            throw ex;
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            em.close();
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Factura factura;
            try {
                factura = em.getReference(Factura.class, id);
                factura.getId(); // throws EntityNotFoundException if not found
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The factura with id " + id + " no longer exists.", enfe);
            }
            em.remove(factura);
            em.getTransaction().commit();
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            em.close();
        }
    }

    public List<Factura> findFacturaEntities() {
        return findFacturaEntities(true, -1, -1);
    }

    public List<Factura> findFacturaEntities(int maxResults, int firstResult) {
        return findFacturaEntities(false, maxResults, firstResult);
    }

    private List<Factura> findFacturaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Factura> q = em.createQuery("select f from Factura f", Factura.class);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Factura findFactura(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Factura.class, id);
        } finally {
            em.close();
        }
    }

    public int getFacturaCount() {
        EntityManager em = getEntityManager();
        try {
            javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            javax.persistence.criteria.Root<Factura> rt = cq.from(Factura.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            javax.persistence.Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
