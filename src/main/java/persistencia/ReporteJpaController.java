package persistencia;

import logica.Reporte;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;
import java.util.List;
import javax.persistence.Persistence;
import persistencia.exceptions.NonexistentEntityException;

public class ReporteJpaController implements Serializable {

    public ReporteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public ReporteJpaController() {
        emf = Persistence.createEntityManagerFactory("MinimarketfinalPU");
    }
    
    public void create(Reporte reporte) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(reporte);
            em.getTransaction().commit();
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            em.close();
        }
    }

    public void edit(Reporte reporte) throws NonexistentEntityException, Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            reporte = em.merge(reporte);
            em.getTransaction().commit();
        } catch (Exception ex) {
            Integer id = reporte.getId();
            if (findReporte(id) == null) {
                throw new NonexistentEntityException("The reporte with id " + id + " no longer exists.");
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
            Reporte reporte;
            try {
                reporte = em.getReference(Reporte.class, id);
                reporte.getId(); // throws EntityNotFoundException if not found
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The reporte with id " + id + " no longer exists.", enfe);
            }
            em.remove(reporte);
            em.getTransaction().commit();
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            em.close();
        }
    }

    public List<Reporte> findReporteEntities() {
        return findReporteEntities(true, -1, -1);
    }

    public List<Reporte> findReporteEntities(int maxResults, int firstResult) {
        return findReporteEntities(false, maxResults, firstResult);
    }

    private List<Reporte> findReporteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Reporte> q = em.createQuery("select r from Reporte r", Reporte.class);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Reporte findReporte(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Reporte.class, id);
        } finally {
            em.close();
        }
    }

    public int getReporteCount() {
        EntityManager em = getEntityManager();
        try {
            javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            javax.persistence.criteria.Root<Reporte> rt = cq.from(Reporte.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            javax.persistence.Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
