/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//importar librerias
import java.sql.*;
import javax.servlet.ServletConfig;

/**
 *
 * @author USER
 */
public class AgregarDocente extends HttpServlet {
    
    // Para evitar que cualquiera se meta a mi BD tienen que ser private
    
   
    private Connection con;
    private Statement set;
    private ResultSet rs;
    
    //definiendo el constructor de la clase
    
    public void init(ServletConfig cfg) throws ServletException{
        //defino como se conecta a la base de datos
        String URL = "jdbc:mysql:3060//localhost/docente";
                     //tipo de conector:manejadorbd:puerto//ip/nombrebd
        String userName = "root";
        String password = "l@wl1et";     
        
        try{
            //lo primero es conectarnos
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            URL = "jdbc:mysql://localhost/docente";
            
            con = DriverManager.getConnection(URL, userName, password);
            set = con.createStatement();
            
            System.out.println("Se ha conectado exitosamente <3 ");            
            
        } catch (Exception e){
            System.out.println("No se ha conectado exitosamente :C ");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
        
    
    }

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
       response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Agregar Docente</title>");   
            out.println("</head>");
            out.println("<body>");
           
             
              try {
                
                String nombre, apellidopaterno, apellidomaterno, turno;
                
               //hay que obtener parametros
               
                
                nombre = request.getParameter("nombre");
                apellidopaterno = request.getParameter("appatdo");
                apellidomaterno = request.getParameter("apmatdo");
                turno = request.getParameter("turno");
                
                //establecer querry
                        String q = "insert into datosdocente values ("+ nombre +""
                        + " '"+ apellidopaterno +"' '"+ apellidomaterno +"',"
                        + " '"+ turno +"')";
                //actualizar la bd
                
                set.executeUpdate(q);
                out.println("<h1>Registro completado</h1>");
                System.out.println("Ha sido registrado correctamente");
                
                
             }catch(Exception e){
                System.out.println("Registo NO exitoso");
                out.println("<h1>No se pudo registrar</h1>");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
            }        
            
            out.println("<a href= 'ConsultarDocente'>Consultar docente</a");
            out.println("</body>");
            out.println("</html>");
           
          
        }
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
        processRequest(request, response);
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
 //creamos el destructor
    //los destructores nos servian para liberar la memoria
    
    public void destroy(){
        try{
            con.close();
        }catch (Exception e){
            super.destroy();
        }
    }

}
