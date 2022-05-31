/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.*;
import javax.servlet.http.*;
import javax.servlet.*;
/**
 *
 * @author dagra
 */
@WebServlet(name = "VerificarEspecialista", urlPatterns = {"/VerificarEspecialista"})
public class VerificarEspecialista extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String usuario, password;
            
            usuario = request.getParameter("usuario");
            password = request.getParameter("password");
            System.out.println(usuario);
            System.out.println(password);
            MPersona persona = new MPersona();
            //verificar al usuario
            
            
            //hay que crear la sesion
            try{
                persona = persona.verificarEspecialista(usuario, password);
                String paginaDestino = "registroEsp.jsp";
            if(persona != null){
                //si existe en la BD
                //se crea la sesion de la bd
                HttpSession sesion = request.getSession();
                sesion.setAttribute("usuario", persona);
                paginaDestino = "especialista/especialista.jsp";
                request.getRequestDispatcher(paginaDestino).forward(request, response);
                
                //otra sesion que obtendra solo el parametro
                HttpSession sesionparametro = request.getSession();
                sesionparametro.setAttribute("usuario", usuario);
                
                //saber el privilegio switch
                
            
            }else{
                String mensaje = "Invalid email/password";
                request.setAttribute("mensaje", mensaje);
            }
            
            RequestDispatcher dispatcher = request.getRequestDispatcher(paginaDestino);
            dispatcher.forward(request, response);
            
            }catch(Exception e){
                throw new ServletException(e);
        }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
