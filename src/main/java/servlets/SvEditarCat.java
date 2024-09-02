/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "SvEditarCat", urlPatterns = {"/SvEditarCat"})
public class SvEditarCat extends HttpServlet {

    Controladora control = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        CategoriaProducto catProd = control.traerCategoria(id);
        
        HttpSession misesion = request.getSession();
        
        misesion.setAttribute("catEditar", catProd);
        
        response.sendRedirect("editarCategorias.jsp");
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
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
        
        CategoriaProducto catProd = (CategoriaProducto) request.getSession().getAttribute("catEditar");
        catProd.setNombre(nombreCat);
        catProd.setDescripcion(descripcionCat);
        catProd.setEstado(estadoCat);
        
        control.editarCategoria(catProd);
        
        
        response.sendRedirect("SvCategorias");
         
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
