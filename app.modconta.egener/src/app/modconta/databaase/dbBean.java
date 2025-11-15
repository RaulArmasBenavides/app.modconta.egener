
package app.modconta.databaase;

import app.modconta.entity.Constantes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class dbBean {
    String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=dblogistica;integratedSecurity=false";
    String dbDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver" ;
    private Connection dbCon;
    private String Login=Constantes.user_sa;
    private String password=Constantes.clave_sa;

 
      public Connection getConnection() {
        try {
            if (dbCon == null || dbCon.isClosed()) {
                Class.forName(dbDriver);
                // Puedes usar cualquiera de las cadenas que ya tenías
                // dbCon = DriverManager.getConnection(this.dbURL, this.Login, this.password);
                dbCon = DriverManager.getConnection(Constantes.CADENA_CONEXION);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener conexión: " + e.getMessage());
        }
        return dbCon;
    }

    public void close() throws SQLException {
        if (dbCon != null && !dbCon.isClosed()) {
            dbCon.close();
        }
    }

    public ResultSet execSQL(String sql) throws SQLException {
        // Usar siempre getConnection() para garantizar que dbCon no es null
        Statement s = getConnection().createStatement();
        ResultSet r = s.executeQuery(sql);
        return (r == null) ? null : r;
    }

    public int updateSQL(String sql) throws SQLException {
        Statement s = getConnection().createStatement();
        int r = s.executeUpdate(sql);
        return r;
    }

    public boolean procedureSQL(String sql) throws SQLException {
        Statement s = getConnection().createStatement();
        boolean r = s.execute(sql);
        return r;
    }

    public void commit() throws SQLException {
        getConnection().commit();
    }

    public void rollback() throws SQLException {
        getConnection().rollback();
    }

    public void AutoCommit(boolean estado) throws SQLException {
        getConnection().setAutoCommit(estado);
    }

   

}
