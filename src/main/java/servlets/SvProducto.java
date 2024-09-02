/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.CategoriaProducto;
import logica.Controladora;
import logica.Producto;

/**
 *
 * @author germa
 */
@WebServlet(name = "SvProducto", urlPatterns = {"/SvProducto"})
public class SvProducto extends HttpServlet {

    Controladora control = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    
    List<CategoriaProducto> listaCategorias = new ArrayList<CategoriaProducto>();
                  
    listaCategorias = control.getCategorias(); 
   
    HttpSession misesion = request.getSession();
    misesion.setAttribute("listaCategorias", listaCategorias);
    
    response.sendRedirect("productos.jsp");
   
            
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre = request.getParameter("nombreProducto");
        double precio = Double.parseDouble(request.getParameter("precioProducto"));
        String descripcion = request.getParameter("descricionPago");
        double cantidad = Double.parseDouble(request.getParameter("cantidad"));
        
        // Obtener la categoría seleccionada por su ID
    int id = Integer.parseInt(request.getParameter("categoriaProducto"));
    
    // Recuperar la instancia de la categoría usando su ID
    CategoriaProducto categoria = control.buscarCategoriaPorId(id);
    
    // Crear un nuevo producto y asignarle la categoría seleccionada
    Producto producto = new Producto();
    producto.setNombre(nombre);
    producto.setPrecio(precio);
    producto.setDescripcion(descripcion);
    producto.setCantidad(cantidad);
    producto.setCategoria(categoria);
        
        // Guardar el producto en la base de datos
    control.crearProducto(nombre, precio, descripcion, cantidad, categoria);
    
    // 
    response.sendRedirect("SvVerProducto");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
