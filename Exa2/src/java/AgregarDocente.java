/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alumno
 */
public class AgregarDocente extends HttpServlet {

    private Connection con;
    private Statement set;
    private ResultSet rs;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Registro de Alumnos</title>");            
            out.println("<link rel='stylesheet' href='css/bootstrap.min.css'");            
            out.println("</head>");
            out.println("<body class='bg-primary me-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center text-white overflow-hidden'>");
            out.println("<div class='bg-light shadow-sm mx-auto' style='border-radius: 21px 21px 21px 21px;'>");
            try{
                //obtener los parametros para poder
                //insertarlos en la BD
                String nom, appat, apmat, user, pass, fecha, sexo, rol, q;
                int nEmpleado;
                
                user = request.getParameter("user");
                pass = request.getParameter("pass");
                nom = request.getParameter("nombre");
                appat = request.getParameter("appat");
                apmat = request.getParameter("apmat");
                fecha = request.getParameter("fecha");
                sexo = request.getParameter("sexo");
                nEmpleado = Integer.parseInt(request.getParameter("empleado"));
                




                System.out.println(user);
                System.out.println(pass);
                System.out.println(nom);
                System.out.println(nEmpleado);
                System.out.println(fecha);
                System.out.println(sexo);
                System.out.println(appat);
                System.out.println(apmat);
                

                q = "insert into mpersona (numero_empleado, nombre, appat, apmat, sexo, fecha_nac, user, pass, Crol_id_rol, Cprivilegio_id_privilegio) " 
                          + "values ("+nEmpleado+", '"+nom+"', '"+appat+"', '"+apmat+"', '"+sexo+"', '"+fecha+"', '"+user+"', '"+pass+"', 2, 2)";
                
                //se debe de preparar ejecutar la sentencia
                set.executeUpdate(q);
                out.println("<h1 class='titulo1'>Docente Registrado con Exito.</h1>");
                System.out.println("Dato registrado");
            
            }catch(Exception e){

                System.out.println("No se pudo registrar verificar los datos de entrada");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
                out.println("<h1 class='titulo2'>Docente No se pudo Registrar, hay un error.</h1>");
            
            }
            
            
            out.println("<br><br><button class='btn btn-dark'><a href='ConsultarAlumnos'>Consultar Alumnos</a></button><br><br>");
            out.println("</div>");
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
