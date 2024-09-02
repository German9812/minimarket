/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.CategoriaProducto;
import logica.Producto;
import logica.Usuario;
import persistencia.exceptions.NonexistentEntityException;


public class ControladoraPersistencia {
    
    AdministradorJpaController adminJPA = new AdministradorJpaController();
    CarritoJpaController carrJPA = new CarritoJpaController();
    CategoriaProductoJpaController categJPA = new CategoriaProductoJpaController();
    ClienteJpaController clienJPA = new ClienteJpaController();
    DescuentoJpaController descJPA = new DescuentoJpaController();
    DetalleFacturaJpaController detJPA = new DetalleFacturaJpaController();
    EmpleadoJpaController empJPA = new EmpleadoJpaController();
    FacturaJpaController factJPA = new FacturaJpaController();
    HorarioJpaController horJPA = new HorarioJpaController();
    InventarioJpaController invJPA = new InventarioJpaController();
    PersonaJpaController persJPA = new PersonaJpaController();
    ProductoJpaController producJPA = new ProductoJpaController();
    ProveedorJpaController provJPA = new ProveedorJpaController();
    ReporteJpaController repJPA = new ReporteJpaController();
    TurnoJpaController turn = new TurnoJpaController();
    UsuarioJpaController usuJPA = new UsuarioJpaController();
    VentaJpaController ventJPA = new VentaJpaController();

    public ControladoraPersistencia() {
    }

    
    
    
    public void crearUsuario(Usuario usu) {
    usuJPA.create(usu);
    }

    public List getUsuarios() {
       return usuJPA.findUsuarioEntities();
    }

    public void borrarUsuario(int id) {
        try {
            usuJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario traerUsuario(int id) {
        return usuJPA.findUsuario(id);
    }

    public void editarUsuario(Usuario usu) {
        try {
            usuJPA.edit(usu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void CrearCategoria(CategoriaProducto catProd) {
        categJPA.create(catProd);
    }

    public List<CategoriaProducto> getCategorias() {
        return categJPA.findCategoriaProductoEntities();
    }

    public void borrarCategoria(int id) {
        try {
            categJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public CategoriaProducto traerCategoria(int id) {
        return categJPA.findCategoriaProducto(id);
    }

    public void editarCategoria(CategoriaProducto catProd) {
        try {
            categJPA.edit(catProd);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public CategoriaProducto buscarCategoria(int id) {
        return categJPA.findCategoriaProducto(id);
    }

    public void crearProducto(Producto producto) {
        producJPA.create(producto);
    }

    public List<Producto> getProductos() {
        return producJPA.findProductoEntities();
    }
    
    
    
    

 
    
}
