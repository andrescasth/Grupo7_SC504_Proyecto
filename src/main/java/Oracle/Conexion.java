/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Oracle;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author andre
 */
public class Conexion {
   
    private static final String url="jdbc:oracle:thin:@localhost:1521:orcl";
    private static final String USER="GRUPO7";
    private static final String PASSWORD ="GRUPO7";
    private static final String DRIVER ="oracle.jdbc.OracleDriver";

    public static Connection getConnection(){
         Connection conexion= null;
   
        try{
            Class.forName(DRIVER);// driver de la base de datos\
            conexion = DriverManager.getConnection(url, USER, PASSWORD);
            
        }catch (ClassNotFoundException e){
            System.out.println("Erroral cargar el driver");
        }catch(SQLException e){
            System.out.println("Error de conexion");
        }
        
        
        return conexion;  
    }

    public CallableStatement prepareCall(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
}
