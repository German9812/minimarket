/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;
import java.util.List;
import persistencia.ControladoraPersistencia;

/**
 *
 * @author germa
 */
public class Controladora {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    public void crearUsuario (String nombreUsuario, String contrasenia, String rol){
        
        Usuario usu = new Usuario();
        usu.setNombreUsuario(nombreUsuario);
        usu.setContrasenia(contrasenia);
        usu.setRol(rol);
        controlPersis.crearUsuario(usu);
    }

    public List getUsuarios() {
      return controlPersis.getUsuarios();
        
    }

    public void borrarUsuario(int id) {
       controlPersis.borrarUsuario(id);
    }

    public Usuario traerUsuario(int id) {
       return controlPersis.traerUsuario(id); 
    }

    public void editarUsuario(Usuario usu) {
        controlPersis.editarUsuario(usu);
    }

    public boolean comprobarIngreso(String usuario, String password) {
        
        boolean ingreso = false;
        
        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        listaUsuarios = controlPersis.getUsuarios();
        
        for (Usuario usu : listaUsuarios){
        if(usu.getNombreUsuario().equals(usuario)){
            if (usu.getContrasenia().equals(password)){
                ingreso = true;
            }
            else{
                ingreso = false;
            }
            }
        }
        return ingreso;
    }
    
    
    
    //Categoria productos//

    public void CrearCategoria(String nombreCat, String descripcionCat, CategoriaProducto.EstadoCategoria estadoCat) {
        
        CategoriaProducto catProd = new CategoriaProducto();
        catProd.setNombre(nombreCat);
        catProd.setDescripcion(descripcionCat);
        catProd.setEstado(estadoCat);
        controlPersis.CrearCategoria(catProd);
    
    }

    public List<CategoriaProducto> getCategorias() {
        return controlPersis.getCategorias();
    }

    public void borrarCategoria(int id) {
     controlPersis.borrarCategoria(id);
    }

    public CategoriaProducto traerCategoria(int id) {
        return controlPersis.traerCategoria(id);
    }

    public void editarCategoria(CategoriaProducto catProd) {
        controlPersis.editarCategoria(catProd);
    }

    public CategoriaProducto buscarCategoriaPorId(int id) {
        return controlPersis.buscarCategoria(id);
    }

    public void crearProducto(String nombre, double precio, String descripcion, double cantidad, CategoriaProducto categoria) {
        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setDescripcion(descripcion);
        producto.setCantidad(cantidad);
        producto.setCategoria(categoria);
        controlPersis.crearProducto(producto);
    }

    public List<Producto> getProductos() {
        return controlPersis.getProductos();
    }

    
 
    
    
    
    
    
}
