/*1.	Implementar un socket en una cadena de cines, 
que permita enviar desde el servidor la actualización de las
películas de la semana, indicando el nombre de la película, tipo de película 
(infantil, acción, comedia, terror, etc) y fecha de estreno.*/

package entity;
import java.io.Serializable;
import java.sql.Date;
/**
 *
 * @author MARCELO
 */
public class Pelicula implements Serializable {
   
    public Pelicula() {
    }

     
     private String Codigo;
     private String Nombre;
     private String Tipo;
     private Date Fecha;

    public Pelicula(String Codigo, String Nombre, String Tipo, Date Fecha) {
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Tipo = Tipo;
        this.Fecha = Fecha;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

     
    /**
    * @return the codigo
    */
    public String getNombre() {
        return Nombre;
    }
    /**
    * @param codigo the codigo to set
    */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    /**
    * @return the codigo
    */
    public String getTipo() {
        return Tipo;
    }
    /**
    * @param codigo the codigo to set
    */
    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
    /**
    * @return the codigo
    */
    public Date getFecha() {
        return Fecha;
    }
    /**
    * @param codigo the codigo to set
    */
    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

   
    
     

}
