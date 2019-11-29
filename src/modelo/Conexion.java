/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;



public class Conexion {
    public Connection conexion;
    
    
    public Connection obtenerConexion() {
            String basededatos="gestion_festival";
            String usuario="segundodam";
            String password="Segundodam";
            
         try {
            Class.forName("com.mysql.jdbc.Driver");
           conexion = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/" + basededatos, usuario, password );
         }catch (Exception e) {
            e.printStackTrace();
        }
        return conexion;
    }

    public void desconectar(Connection conexion) {
        try {
            conexion.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
}
