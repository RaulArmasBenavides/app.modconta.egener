package MODEL;
import app.modconta.databaase.dbBean;
import app.modconta.entity.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class EmpleadoDAO {
    //funcion listar
  public Vector<Empleado> ListaItem(boolean sw, String str){
     Vector<Empleado> item = new Vector<Empleado>();
        dbBean con = new dbBean();
        String sql = "Select * from Empleado";
        //El criterio de busqueda para mostrar datos 
        if(sw == true)
        {
            sql = sql + " where Nombre like '"+str +"%'";
        }
        System.out.println("FII: "+ sql);
        try{
            ResultSet resultado = con.execSQL(sql);
            while(resultado.next()){
                 Empleado e ; 
                 e = new Empleado();
                 e.setIdEmpleado(resultado.getInt(1));
                 e.setCodigoContrato(resultado.getString(2));
                 e.setNombre(resultado.getString(3));
                 e.setApellidoPaterno(resultado.getString(4));
                 e.setSexo(resultado.getString(5));
                 e.setTelefono(resultado.getString(6));
                 e.setDNI(resultado.getString(7));
                 e.setDireccion(resultado.getString(8));
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
  
    public int procesaItem(Empleado p, String proc) {
      int resultado = 0;
      dbBean con = new dbBean();
      Connection cn = null;
      PreparedStatement ps = null;

      String sqlInsert = "INSERT INTO Empleado " +
                         "(IdEmpleado, CodigoContrato, Nombre, Apellidos, Sexo, Telefono, DNI, Direccion) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

      String sqlUpdate = "UPDATE Empleado SET " +
                         "CodigoContrato = ?, " +
                         "Nombre         = ?, " +
                         "Apellidos      = ?, " +
                         "Sexo           = ?, " +
                         "Telefono       = ?, " +
                         "DNI            = ?, " +
                         "Direccion      = ? " +
                         "WHERE IdEmpleado = ?";

      try {
          cn = con.getConnection();

          if ("insert".equalsIgnoreCase(proc)) {
              ps = cn.prepareStatement(sqlInsert);

              ps.setInt(1, p.getIdEmpleado());
              ps.setString(2, p.getCodigoContrato());
              ps.setString(3, p.getNombre());
              ps.setString(4, p.getApellidoPaterno());
              ps.setString(5, p.getSexo());
              ps.setString(6, p.getTelefono());
              ps.setString(7, p.getDNI());
              ps.setString(8, p.getDireccion());

          } else if ("update".equalsIgnoreCase(proc)) {
              ps = cn.prepareStatement(sqlUpdate);

              // mismos campos pero al final el IdEmpleado en el WHERE
              ps.setString(1, p.getCodigoContrato());
              ps.setString(2, p.getNombre());
              ps.setString(3, p.getApellidoPaterno());
              ps.setString(4, p.getSexo());
              ps.setString(5, p.getTelefono());
              ps.setString(6, p.getDNI());
              ps.setString(7, p.getDireccion());
              ps.setInt(8, p.getIdEmpleado());

          } else {
              // operación desconocida
              System.out.println("Operación no reconocida en procesaItem: " + proc);
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
              con.close();
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }

      return resultado;
  }

    
}
