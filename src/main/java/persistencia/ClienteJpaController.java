package persistencia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import logica.Cliente;
import logica.Factura;
import logica.Venta;
import persistencia.exceptions.NonexistentEntityException;

public class ClienteJpaController implements Serializable {

    public ClienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public ClienteJpaController() {
        emf = Persistence.createEntityManagerFactory("MinimarketfinalPU");
    }
    
    public void create(Cliente cliente) {
        if (cliente.getFacturas() == null) {
            cliente.setFacturas(new ArrayList<Factura>());
        }
        if (cliente.getVentas() == null) {
            cliente.setVentas(new ArrayList<Venta>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();

            // Adjuntar facturas
            List<Factura> attachedFacturas = new ArrayList<Factura>();
            for (Factura facturaToAttach : cliente.getFacturas()) {
                facturaToAttach = em.getReference(facturaToAttach.getClass(), facturaToAttach.getId());
                attachedFacturas.add(facturaToAttach);
            }
            cliente.setFacturas(attachedFacturas);

            // Adjuntar ventas
            List<Venta> attachedVentas = new ArrayList<Venta>();
            for (Venta ventaToAttach : cliente.getVentas()) {
                ventaToAttach = em.getReference(ventaToAttach.getClass(), ventaToAttach.getId());
                attachedVentas.add(ventaToAttach);
            }
            cliente.setVentas(attachedVentas);

            em.persist(cliente);

            // Actualizar cliente en facturas
            for (Factura factura : cliente.getFacturas()) {
                Cliente oldClienteOfFactura = factura.getCliente();
                factura.setCliente(cliente);
                factura = em.merge(factura);
                if (oldClienteOfFactura != null) {
                    oldClienteOfFactura.getFacturas().remove(factura);
                    em.merge(oldClienteOfFactura);
                }
            }

            // Actualizar cliente en ventas
            for (Venta venta : cliente.getVentas()) {
                Cliente oldClienteOfVenta = venta.getCliente();
                venta.setCliente(cliente);
                venta = em.merge(venta);
                if (oldClienteOfVenta != null) {
                    oldClienteOfVenta.getVentas().remove(venta);
                    em.merge(oldClienteOfVenta);
                }
            }

            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cliente cliente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();

            Cliente persistentCliente = em.find(Cliente.class, cliente.getId());
            List<Factura> facturasOld = persistentCliente.getFacturas();
            List<Factura> facturasNew = cliente.getFacturas();
            List<Venta> ventasOld = persistentCliente.getVentas();
            List<Venta> ventasNew = cliente.getVentas();

            // Adjuntar nuevas facturas
            List<Factura> attachedFacturasNew = new ArrayList<Factura>();
            for (Factura facturaNew : facturasNew) {
                facturaNew = em.getReference(facturaNew.getClass(), facturaNew.getId());
                attachedFacturasNew.add(facturaNew);
            }
            facturasNew = attachedFacturasNew;
            cliente.setFacturas(facturasNew);

            // Adjuntar nuevas ventas
            List<Venta> attachedVentasNew = new ArrayList<Venta>();
            for (Venta ventaNew : ventasNew) {
                ventaNew = em.getReference(ventaNew.getClass(), ventaNew.getId());
                attachedVentasNew.add(ventaNew);
            }
            ventasNew = attachedVentasNew;
            cliente.setVentas(ventasNew);

            cliente = em.merge(cliente);

            // Manejar facturas
            for (Factura facturaOld : facturasOld) {
                if (!facturasNew.contains(facturaOld)) {
                    facturaOld.setCliente(null);
                    em.merge(facturaOld);
                }
            }
            for (Factura facturaNew : facturasNew) {
                if (!facturasOld.contains(facturaNew)) {
                    Cliente oldClienteOfFacturaNew = facturaNew.getCliente();
                    facturaNew.setCliente(cliente);
                    em.merge(facturaNew);
                    if (oldClienteOfFacturaNew != null && !oldClienteOfFacturaNew.equals(cliente)) {
                        oldClienteOfFacturaNew.getFacturas().remove(facturaNew);
                        em.merge(oldClienteOfFacturaNew);
                    }
                }
            }

            // Manejar ventas
            for (Venta ventaOld : ventasOld) {
                if (!ventasNew.contains(ventaOld)) {
                    ventaOld.setCliente(null);
                    em.merge(ventaOld);
                }
            }
            for (Venta ventaNew : ventasNew) {
                if (!ventasOld.contains(ventaNew)) {
                    Cliente oldClienteOfVentaNew = ventaNew.getCliente();
                    ventaNew.setCliente(cliente);
                    em.merge(ventaNew);
                    if (oldClienteOfVentaNew != null && !oldClienteOfVentaNew.equals(cliente)) {
                        oldClienteOfVentaNew.getVentas().remove(ventaNew);
                        em.merge(oldClienteOfVentaNew);
                    }
                }
            }

            em.getTransaction().commit();
        } catch (Exception ex) {
            int id = cliente.getId();
            if (findCliente(id) == null) {
                throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.");
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente cliente;
            try {
                cliente = em.getReference(Cliente.class, id);
                cliente.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.", enfe);
            }

            // Desasociar facturas
            List<Factura> facturas = cliente.getFacturas();
            for (Factura factura : facturas) {
                factura.setCliente(null);
                em.merge(factura);
            }

            // Desasociar ventas
            List<Venta> ventas = cliente.getVentas();
            for (Venta venta : ventas) {
                venta.setCliente(null);
                em.merge(venta);
            }

            em.remove(cliente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cliente> findClienteEntities() {
        return findClienteEntities(true, -1, -1);
    }

    public List<Cliente> findClienteEntities(int maxResults, int firstResult) {
        return findClienteEntities(false, maxResults, firstResult);
    }

    private List<Cliente> findClienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cliente.class));
            javax.persistence.Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Cliente findCliente(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cliente.class, id);
        } finally {
            em.close();
        }
    }

    public int getClienteCount() {
        EntityManager em = getEntityManager();
        try {
            javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            javax.persistence.criteria.Root<Cliente> rt = cq.from(Cliente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            javax.persistence.Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
