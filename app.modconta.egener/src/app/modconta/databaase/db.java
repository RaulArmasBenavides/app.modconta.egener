/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.modconta.databaase;

import app.modconta.entity.Constantes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author MARCELO
 */
public class db {
    
   
    public Connection getConnection() {
        Connection cn = null;

        try {
          //para oracle
          // Class.forName("oracle.jdbc.OracleDriver").newInstance();
          //para sqlserver 
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
         //para oracle 
         //cn = DriverManager.getConnectio("jdbc:oracle:thin:@localhost:1521:XE","neptuno", "admin");
         // para sql server 
         cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=dblogistica",Constantes.user_sa,Constantes.clave_sa);
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            System.out.println(ex);
        }

        return cn;
      
   }
}
