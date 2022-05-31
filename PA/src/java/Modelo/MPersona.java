/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;



/**
 *
 * @author dagra
 */
import Control.Conexion;
import java.sql.*;


public class MPersona {
    private int id_persona;
    private int edad;
    private String nombre;
    private String appat;
    private String apmat;
    private String password;
    private String usuario;
    private String fecha_nac;
    private String sexo;
    private String curp;
    
    
    
    //aqui va el crud
    
    //aqui va un metodo para verificar al usuario
    
    /*
    select * from mpersona where persona_user=? and persona_pass=?
    */
    
    public MPersona verificarEspecialista(String usuario, String password)throws SQLException,
            ClassNotFoundException{
        //objeto de la persona
        MPersona persona = null;
        //objeto de conexion
        Connection con = null;
        //Preparacion de la sentencia
        PreparedStatement ps = null;
        //Consultas
        ResultSet rs = null;
        
        try{
            //establecemos la conexion
            con = Conexion.getConection();
            String q = "select * from mpersona join manalista on mpersona.id_persona=manalista.id_persona"
                        + " where usuario = ? and contraseña = ?";
            ps = con.prepareStatement(q);
            //preparo la sentencia
            ps.setString(1, usuario);
            ps.setString(2, password);
            //ejecutamos la busqueda
            rs = ps.executeQuery();
            //buscamos al usuario
            while(rs.next()){
                persona = new MPersona();
                
                persona.setId_persona(rs.getInt("id_persona"));
                persona.setEdad(rs.getInt("edad"));
                persona.setNombre(rs.getString("nombre"));
                persona.setAppat(rs.getString("appat"));
                persona.setApmat(rs.getString("apmat"));
                persona.setPassword(rs.getString("contraseña"));
                persona.setUsuario(rs.getString("usuario"));
                persona.setFecha_nac(rs.getString("fecha_nac"));
                persona.setSexo(rs.getString("sexo"));
                persona.setCurp(rs.getString("curp"));
                
            }
        
        }catch(SQLException sq){
            System.out.println("Error al verificar el usuario");
            System.out.println(sq.getMessage());
        
        }finally{
            try{
                //cerrar conexiones
                rs.close();
                ps.close();
                con.close();
            }catch(Exception ex){
            System.out.println("No se encontro la clase");
            System.out.println(ex.getMessage());
        }
        }
        return persona;
   }
    
    public MPersona registrarEspecialista(String usuario, String password, String nombre,
            String appat, String apmat, String curp,int edad, int cedula, String fecha_nac)throws SQLException,
            ClassNotFoundException{
        //objeto de la persona
        MPersona persona = null;
        //objeto de conexion
        Connection con = null;
        //Preparacion de la sentencia
        PreparedStatement ps = null;
        //Consultas
        ResultSet rs = null;
        
        try{
            //establecemos la conexion
            con = Conexion.getConection();
            String q = "insert into mpersona values(null, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(q);
            //preparo la sentencia
            ps.setString(1, nombre);
            ps.setString(2, appat);
            ps.setString(3, apmat);
            ps.setInt(4, edad);
            ps.setString(5, password);
            ps.setString(6, usuario);
            ps.setString(7, fecha_nac);
            ps.setString(8, sexo);
            ps.setString(9, curp);
            //ejecutamos la busqueda
            rs = ps.executeQuery();
            //buscamos al usuario
            
            String r = "select * from mpersona where curp = '"+curp+"'";
            ps = con.prepareStatement(r);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                persona = new MPersona();
                
                persona.setId_persona(rs.getInt("id_persona"));
                
            }
            String s = "insert into manalista values(null, ?, ?)";
            ps = con.prepareStatement(s);
            
            ps.setInt(1,cedula);
            ps.setInt(2,persona.getId_persona());
        
        }catch(SQLException sq){
            System.out.println("Error al verificar el usuario");
            System.out.println(sq.getMessage());
        
        }finally{
            try{
                //cerrar conexiones
                rs.close();
                ps.close();
                con.close();
            }catch(Exception ex){
            System.out.println("No se encontro la clase");
            System.out.println(ex.getMessage());
        }
        }
        return persona;
   }



    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAppat() {
        return appat;
    }

    public void setAppat(String appat) {
        this.appat = appat;
    }

    public String getApmat() {
        return apmat;
    }

    public void setApmat(String apmat) {
        this.apmat = apmat;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int persona_id) {
        this.id_persona = persona_id;
    }



}
