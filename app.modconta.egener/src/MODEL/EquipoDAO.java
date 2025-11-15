package MODEL;
import app.modconta.databaase.dbBean;
import app.modconta.entity.Equipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class EquipoDAO {

//funcion listar  
    public Vector<Equipo> ListaItem(boolean sw, String str){
       Vector<Equipo> item = new Vector<Equipo>();
        dbBean con = new dbBean();
        String sql = "Select * from Equipo";
        //El criterio de busqueda para mostrar datos 
        if(sw == true)
        {
            sql = sql + " where Nombre_Equipo like '"+str +" %'";
        }
        System.out.println("FII: "+ sql);
        try{
            ResultSet resultado = con.execSQL(sql);
            while(resultado.next()){
                Equipo e; 
                e = new Equipo();
                e.setIdEquipo(resultado.getInt(1));
                e.setNombreEquipo(resultado.getString(2));
                e.setProcesador(resultado.getString(3));
                e.setRam(resultado.getString(4));
                e.setSistemaOperativo(resultado.getString(5));
                e.setTarjetaMadre(resultado.getString(6));
                e.setStock(resultado.getInt(7));
                e.setStockMax(resultado.getInt(8));
                e.setStockMin(resultado.getInt(9));
                e.setIdModelo(resultado.getInt(10));
                        
                item.addElement(e);
            }
            
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.close();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        
        return item;
    }

    
public int FindID(String s ) 
 {   
     dbBean con2 = new dbBean();  
     int id = 0 ;
     try {
         
     String sidmodelo= "Select idModelo,Nombre_Modelo from Modelo where Nombre_Modelo= '"+ s +"'";
     System.out.println(sidmodelo);
     ResultSet resultado2 = con2.execSQL(sidmodelo);
       while(resultado2.next()){
     System.out.println(resultado2.getInt(1));
     //id=Integer.parseInt(resultado2.getInt(1));
        id= resultado2.getInt(1);
       }
     } 
     catch (java.sql.SQLException e) {
         e.printStackTrace();
     }
       try{
            con2.close();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
       return id; 
 
 }
    
     public int procesaItem(Equipo p, String proc) {
    int resultado = 0;
    dbBean db = new dbBean();
    Connection cn = null;
    PreparedStatement ps = null;

    // Ajusta los nombres de columnas si en tu BD son distintos
    String sqlInsert = "INSERT INTO Equipo " +
            "(IdEquipo, Nombre_equipo, SO, Procesador, RAM, TarjetaMadre, Stock, StockMax, StockMin, IdModelo) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    String sqlUpdate = "UPDATE Equipo SET " +
            "Nombre_equipo = ?, " +
            "SO            = ?, " +
            "Procesador    = ?, " +
            "RAM           = ?, " +
            "TarjetaMadre  = ?, " +
            "Stock         = ?, " +
            "StockMax      = ?, " +
            "StockMin      = ?, " +
            "IdModelo      = ? " +
            "WHERE IdEquipo = ?";

    try {
        cn = db.getConnection();

        if ("insert".equalsIgnoreCase(proc)) {

            ps = cn.prepareStatement(sqlInsert);

            ps.setInt(1,  p.getIdEquipo());
            ps.setString(2, p.getNombreEquipo());
            ps.setString(3, p.getSistemaOperativo());
            ps.setString(4, p.getProcesador());
            ps.setString(5, p.getRam());
            ps.setString(6, p.getTarjetaMadre());
            ps.setInt(7,  p.getStock());
            ps.setInt(8,  p.getStockMax());
            ps.setInt(9,  p.getStockMin());
            ps.setInt(10, p.getIdModelo());

        } else if ("update".equalsIgnoreCase(proc)) {

            ps = cn.prepareStatement(sqlUpdate);

            ps.setString(1, p.getNombreEquipo());
            ps.setString(2, p.getSistemaOperativo());
            ps.setString(3, p.getProcesador());
            ps.setString(4, p.getRam());
            ps.setString(5, p.getTarjetaMadre());
            ps.setInt(6,  p.getStock());
            ps.setInt(7,  p.getStockMax());
            ps.setInt(8,  p.getStockMin());
            ps.setInt(9,  p.getIdModelo());
            ps.setInt(10, p.getIdEquipo()); // WHERE

        } else {
            System.out.println("Operación no reconocida en procesaItem(Equipo): " + proc);
            return 0;
        }

        resultado = ps.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (ps != null) ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            db.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    return resultado;
}
 

public int FindIDEquipo(String s ) 
 {   
     dbBean con2 = new dbBean();  
     int id = 0 ;
     try {
         
     String sidequipo= "Select idEquipo,Nombre_Equipo from Equipo where Nombre_Equipo= '"+ s +"'";
     System.out.println(sidequipo);
     ResultSet resultado2 = con2.execSQL(sidequipo);
       while(resultado2.next()){
     System.out.println(resultado2.getInt(1));
     //id=Integer.parseInt(resultado2.getInt(1));
        id= resultado2.getInt(1);
       }
     } 
     catch (java.sql.SQLException e) {
         e.printStackTrace();
     }
       try{
            con2.close();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
       return id; 
 
 }

}
