/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

/**
 *
 * @author dagra
 */

import java.sql.*;

public class Conexion {
    
    public static  Connection getConection(){
        try{
            String url, name, pass;
            Class.forName("com.mysql.jdbc.Driver");
            url = "jdbc:mysql://localhost/pa";
            name = "root";
            pass = "n0m3l0";
            
            return DriverManager.getConnection(url, name, pass);
        
        }catch(SQLException sq){
            System.out.println("Error al conectar la BD");
            System.out.println(sq.getMessage());
        }catch(Exception ex){
            System.out.println("Error al no encontrar la clase");
            System.out.println(ex.getMessage());
        
        }
        return null;
    }
    
}
