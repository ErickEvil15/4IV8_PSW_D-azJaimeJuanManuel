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
public class RegistrarMaquina extends HttpServlet {

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
                String laboratorio, fecha, hora, etiqueta, serial; 
                String cpu, monitor, accesorios, grupo, asignatura, docenteN, docenteAppat, docenteApmat, problema, configuracion, estado, prioridad;
                String q, r, s, t, u;
                String nEmpleado;
                
                laboratorio = request.getParameter("laboratorio");
                fecha = request.getParameter("fecha");
                hora = request.getParameter("hora");
                etiqueta = request.getParameter("etiqueta");
                serial = request.getParameter("serial");
                estado = request.getParameter("estado");
                monitor = request.getParameter("monitor");
                accesorios = request.getParameter("accesorios");
                prioridad = request.getParameter("prioridad");
                grupo = request.getParameter("grupo");
                docenteN = request.getParameter("docenteN");
                asignatura = request.getParameter("asignatura");
                problema = request.getParameter("problema");
                docenteApmat = request.getParameter("docenteApmat");
                docenteAppat = request.getParameter("docenteAppat");
                docenteN = request.getParameter("docenteN");
                configuracion =request.getParameter("os");
                nEmpleado = request.getParameter("nEmpleado");


                System.out.println(docenteN);
                System.out.println(docenteAppat);
                System.out.println(docenteApmat);
                System.out.println(nEmpleado);


                
                r = "insert into mequipo (problema, MCPU_id_maquina, Mmonitor_id_monitor, Caccesorios_id_accesorios,"
                                        +" Mconfiguracion_id_configuracion, Claboratorio_id_lab) "
                                        +"value ('"+problema+"', 1, 1, 1, "+configuracion+", "+laboratorio+")";
                
                set.executeUpdate(r);
                out.println("Maquina y problema registrado");


                //que tipo de querry voy a realizar
                q = "select * from mequipo where problema='"+problema+"'";
                
                set = con.createStatement();
                rs = set.executeQuery(q);
                try{
                    while(rs.next()){
                        int equipo = rs.getInt("id_equipo");

                    s = "insert into EreportesEquipo (Mequipo_id_equipo) values ("+equipo+")";
                    set.executeUpdate(s);
                    }
                rs.close();
                set.close();
                    
                }catch(Exception e){
                    System.out.println("entro el dato");
                }

                t = " select * from mpersona where numero_empleado="+nEmpleado+" and nombre=' "+docenteN+"' and apmat='"+docenteApmat+"' and appat='"+docenteAppat+"';";
               

                set = con.createStatement();
                rs = set.executeQuery(t);
                try{
                    while(rs.next()){
                        int persona = rs.getInt("id_persona");
                        int rol = rs.getInt("Crol_id_rol");

                    u = "insert into ereportemaquina (Mpersona_id_persona, Mpersona_Crol_id_rol) values ("+persona+","+rol+")";

                    set.executeUpdate(u);
                    }
                rs.close();
                set.close();
                }catch(Exception e){
                    System.out.println("entro el dato en reporte");
                }


//registroreporte
                t = " select id_reporte, mequipo_id_equipo,id_reportemaquina, mpersona_id_persona, mpersona_crol_id_rol, id_persona, numero_empleado,"
                    +" problema from ereportesequipo join ereportemaquina join mpersona join mequipo on mpersona_id_persona=id_persona and mequipo_id_equipo=id_equipo "
                    +"where problema='"+problema+"' and numero_empleado="+nEmpleado+";";
               

                set = con.createStatement();
                rs = set.executeQuery(t);
                try{
                    while(rs.next()){
                        int reporte = rs.getInt("id_reporte");
                        int reporteM = rs.getInt("id_reportemaquina");

                    u = "insert into dreporte (EReporte_id_Reporte, Casignatura_id_asignatura, Cgrupo_id_grupo,"
                        +" CestadoReporte_id_er, Cprioridad_id_prioridad, Cestadomaquina_id_edomaquina, "
                        +"fecha, hora, EReporteMaquina_id_ReporteMaquina)"
                        +" values ("+reporte+", "+asignatura+", "+grupo+", 2, "+prioridad+", "+estado+", '"+fecha+"', '"+hora+"', "+reporteM+");";

                    set.executeUpdate(u);
                    }
                rs.close();
                set.close();
                }catch(Exception e){
                    System.out.println("entro el dato en dreporte");
                }

                System.out.println("Dato registrado");
            
            }catch(Exception e){
                System.out.println("No se pudo registrar verificar los datos de entrada");
                out.println(e);
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
                out.println("<h1 class='titulo2'>Maquina No se pudo Registrar, hay un error.</h1>");
                
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
