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

/**
 *
 * @author germa
 */
@WebServlet(name = "SvCategorias", urlPatterns = {"/SvCategorias"})
public class SvCategorias extends HttpServlet {
    
    Controladora control = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<CategoriaProducto> listaCategoria = new ArrayList<CategoriaProducto>();
        
        listaCategoria = control.getCategorias();
        
        HttpSession misesion = request.getSession();
        misesion.setAttribute("listaCategoria", listaCategoria);
        
        response.sendRedirect("mostrarCategorias.jsp");
         
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
        String nombreCat = request.getParameter("nombreCategoria");
        String descripcionCat = request.getParameter("descripcionCategoria");
        String estadoCatStr = request.getParameter("estado");
        
         // Convertir el estado de String a Enum
        CategoriaProducto.EstadoCategoria estadoCat;
        try {
            estadoCat = CategoriaProducto.EstadoCategoria.valueOf(estadoCatStr);
        } catch (IllegalArgumentException e) {
            // Manejo de error si el estado no es válido
            throw new ServletException("Estado inválido: " + estadoCatStr);
        }
        
        CategoriaProducto catProd = new CategoriaProducto();
        catProd.setNombre(nombreCat);
        catProd.setDescripcion(descripcionCat);
        catProd.setEstado(estadoCat);
        
        control.CrearCategoria(nombreCat,descripcionCat,estadoCat);
        
        response.sendRedirect("SvCategorias");
        
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
