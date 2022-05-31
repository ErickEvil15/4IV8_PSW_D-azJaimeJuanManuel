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
@WebServlet(name = "RegistroEspecialista", urlPatterns = {"/RegistroEspecialista"})
public class RegistroEspecialista extends HttpServlet {

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
        String nombre, appat, apmat, password, usuario, fecha_nac, sexo, curp;
        int edad, cedula;
        
        nombre = request.getParameter("nombre");
        appat = request.getParameter("appat");
        apmat = request.getParameter("apmat");
        password = request.getParameter("password");
        usuario = request.getParameter("usuario");
        fecha_nac = request.getParameter("fecha_nac");
        sexo = request.getParameter("sexo");
        curp = request.getParameter("curp");
        edad = Integer.parseInt(request.getParameter("edad"));
        cedula = Integer.parseInt(request.getParameter("cedula"));
        
        
        MPersona persona = new MPersona();

        try{
            String paginaDestino = "registroEsp.jsp";
            persona = persona.verificarEspecialista(usuario, password);
            System.out.println("1");
            if(persona == null){
                System.out.println("12");
                persona = persona.registrarEspecialista(usuario, password, nombre,
                appat, apmat, curp, edad, cedula, fecha_nac);
                request.getRequestDispatcher(paginaDestino).forward(request, response);
                System.out.println("2");

            }else{
                String mensaje = "Invalid email/password";
                request.setAttribute("mensaje", mensaje);
                System.out.println("3");
            }

            request.getRequestDispatcher(paginaDestino).forward(request, response);
            System.out.println("4");
            }catch(Exception e){
                throw new ServletException(e);
        }
        String paginaDestino = "registroEsp.jsp";
        System.out.println(nombre+ appat+ apmat+ password+ usuario+ fecha_nac+ sexo+ curp+edad+cedula);
        request.getRequestDispatcher(paginaDestino).forward(request, response);
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
