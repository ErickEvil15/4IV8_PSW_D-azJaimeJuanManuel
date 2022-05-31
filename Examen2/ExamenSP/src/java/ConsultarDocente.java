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
public class ConsultarDocente extends HttpServlet {
    
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
            //css
            out.println("<style>"
                    +"*{"
                    +"background-color: #DFE1F6; color:black; text-align:center;"
                    + "}"
                    +"h1{"
                    +"color:#161D69;"
                    + "}"
                    +"table{"
                    +"border-collapse:separate;"
                    +"border-spacing: 5px; background: #B7CEE4;"
                    + "}" 
            );
            
            
            
            
            out.println("</style>");
            
            out.println("</head>");
            out.println("<body>");
           
            out.println("<h1>Infomación docente</h1>"
                     + "<table align='center' border=2>"
                        + "<tr>"
                            + "<th>Nombre</th>"
                         
                            + "<th>Turno</th>"
                        + "</tr>");
            
              try {
                
                String nombre, appatdo, apmado, turno;
                
                //establecer querry
                String q = "select * from datosdocente";
                
                set = con.createStatement();
                // ya que es un tipo de sentencia "select" se usa a rs
                rs = set.executeQuery(q);
                
                //ya que no sabemos cuantos datos hay en la tabla, recorrer:
                
                while(rs.next()){
                    nombre = rs.getString("nombre");
                    appatdo = rs.getString("appatdo");
                    apmado = rs.getString("apmatdo");
                    turno = rs.getString("turno");
                    
                    out.println("<tr>"
                                
                                + "<td>"+nombre+""+appatdo+" "
                                +apmado+"</td>"
                                + "<td>"+turno+"</td>"
                            + "</tr>");
                    
                }
                
                //hay que cerrar conexiones
                
                rs.close();
                set.close();
            
            } catch(Exception e){
                System.out.println("Error al conectar a la tabla"); 
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
                
                     
            }
            
            out.println("</table>");
            out.println("<br>");
            
            out.println("<a href = 'principal.html'>Volver</a>");
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

}
