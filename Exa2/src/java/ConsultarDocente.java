/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.ServletConfig;



/**
 *
 * @author Alumno
 */
public class ConsultarDocente extends HttpServlet {

    /**
     *Para poder establecer una conexion con bd
     * es necesario contar con 3 tipos de objeto muy especificos
     * los cuales son:
     * Connection es el encargado de establecer la
     *              conexion con el servidor BD
     * Statement sirve para poder definir y manipular
     *              los diferentes objetos de las querrys
     *              como por ejemplo: create, delete, insert,
     *              update, drop, etc
     * ResultSet el cual sirve para poder realizar las consultas
     *              a la BD
     * 
     * 
     */
    
    private Connection con;
    private Statement set;
    private ResultSet rs;
    
    //lo segundo se debe de tener el constructor
    
    
    public void init(ServletConfig scg) throws ServletException{
        //se dene de establecer los elementos para la conexion con bd
        String url = "jdbc:mysql:3306//localhost/mydb";
                   //controlador:motorBD:puerto//IP/nombreBD
        String username = "root";
        String password = "n0m3l0";
        
        try{
            //internat conectar a la bd
            Class.forName("com.mysql.jdbc.Driver");
            url = "jdbc:mysql://localhost/mydb";
            con = DriverManager.getConnection(url, username, password);
            set = con.createStatement();
            
            System.out.println("Si conecto a la BD :3 *w* ");
            
        }catch(Exception e){
            System.out.println("No conecto, solo juguito contigo uwu");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        
        }
    }
    
    
    
    
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Tabla de Alumnos de Batiz</title>");
            out.println("<link rel='stylesheet' href='css/bootstrap.min.css'");            
            out.println("</head>");
            out.println("<body class='bg-primary me-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center text-blue overflow-hidden'>");
          
            out.println("<div class='bg-light shadow-sm mx-auto' text-center style='border-radius: 21px 21px 21px 21px;'>");


            out.println("<h1>Lista de Alumnos de Batiz</h1>"
                    + "<br>"
                    + "<table border='2' style='margin: 0 auto'>"
                        + "<tr>"
                            + "<th width='300'>Numero de empleado</th>"
                            + "<th width='300'>Nombre del Docente</th>"
                            + "<th width='300'>Fecha de nacimiento</th>"
                            + "<th width='300'>Sexo</th>"
                            + "<th width='300'>Rol escolar</th>"
                            + "<th width='300'>Privilegios</th>"
                        + "</tr>");
            try{
                int bol;
                String persona, numero, nom, appat, apmat, sex, fecha, rol, privilegio, pass, user;
   

                numero = request.getParameter("nEmpleado");
                user = request.getParameter("user");
                pass = request.getParameter("pass");
                //que tipo de querry voy a realizar
                String q = "select id_persona, numero_empleado,"
                            +" nombre, appat, apmat, sexo, fecha_nac,"
                            +" user, pass, tipo_rol, tipo_privilegio "
                            +"from mpersona join crol join cprivilegio "
                            +"on id_privilegio=Cprivilegio_id_privilegio and crol_id_rol=id_rol "
                            +"where user='"+user+"' and pass='"+pass+"' and numero_empleado="+numero+";";


                
                set = con.createStatement();
                rs = set.executeQuery(q);
                
                while(rs.next()){
                    numero = rs.getString("numero_empleado");
                    nom = rs.getString("nombre");
                    appat = rs.getString("appat");
                    apmat = rs.getString("apmat");
                    sex = rs.getString("sexo");
                    fecha = rs.getString("fecha_nac");
                    rol = rs.getString("tipo_rol");
                    privilegio = rs.getString("tipo_privilegio");
                    
                    out.println("<tr>"
                                + "<td>"+numero+"</td>"
                                + "<td>"+nom+" "+appat+" "+apmat+"</td>"
                                + "<td>"+fecha+"</td>"
                                + "<td>"+sex+"</td>"
                                + "<td>"+rol+"</td>"
                                + "<td>"+privilegio+"</td>"
                            + "</tr>");
                }
                
                rs.close();
                set.close();
                
                
            
            }catch(Exception e){
                System.out.println("Error al conectar la tabla T_T");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
            
            }
            
            out.println("</table>"
                    + "<br>"
                    + " <button class='btn btn-dark'> <a href='docente.html' >Regresar a Principal</a></button>"
                    + "</div>");
            out.println("</body>");
            out.println("</html>");
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
    
    public void destroy(){
        try{
            con.close();
        }catch(Exception e){
            super.destroy();
        }
    }

}
