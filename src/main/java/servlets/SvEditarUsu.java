/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Usuario;


@WebServlet(name = "SvEditarUsu", urlPatterns = {"/SvEditarUsu"})
public class SvEditarUsu extends HttpServlet {
    
    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id =  Integer.parseInt(request.getParameter("id"));
        Usuario usu = control.traerUsuario(id);
        
        HttpSession misesion = request.getSession();
        
        misesion.setAttribute("usuEditar", usu);
        
        response.sendRedirect("editarUsuarios.jsp");
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombreusu = request.getParameter("username");
        String contra = request.getParameter("password");
        String rol = request.getParameter("rol");
        
        Usuario usu = (Usuario)request.getSession().getAttribute("usuEditar");
        usu.setNombreUsuario(nombreusu);
        usu.setContrasenia(contra);
        usu.setRol(rol);
        
        control.editarUsuario(usu);
        
        response.sendRedirect("SvUsuarios");
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
