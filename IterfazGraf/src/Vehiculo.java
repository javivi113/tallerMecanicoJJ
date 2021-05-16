import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Vehiculo {
	public String matricula, marca, modelo, dniCli;
	public int año;
	private static Connection javOra= null;
	public Vehiculo(String matricula, String marca, String modelo, int año, String dniCli) {
		this.matricula=matricula;
		this.marca=marca;
		this.modelo=modelo;
		this.año=año;
		this.dniCli=dniCli;
	}
	public String toString() {
		return "INSERT INTO VEHICULOS values ('"+this.matricula+"', '"+this.marca+"', "+this.año+",'"+this.dniCli+"');";
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getDniCli() {
		return dniCli;
	}
	public void setDniCli(String dniCli) {
		this.dniCli = dniCli;
	}
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		this.año = año;
	}
	private static Connection conexionOra() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			javOra = DriverManager.getConnection("jdbc:oracle:thin:@91.200.117.27:49161:xe","G3","plaiaundi");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return javOra;

	}
	public void elimVehiculo() {
		try {
			// Conexion 
	        Conexion conn = new Conexion();
	        Connection conex = conn.conexOra();
	        Statement deletQCon=conex.createStatement();
			String queryDel="DELETE FROM VEHICULO WHERE MATRICULA='"+this.matricula+"'";
			deletQCon.execute(queryDel);
		} catch (SQLException ex) {
			ex.getStackTrace();
			//System.out.println("Error a la hora de guardar V en la base de datos");
		}
	}
	public void añadirVehiculo() {
		try {
			// Conexion 
	        Conexion conn = new Conexion();
	        Connection conex = conn.conexOra();
	        Statement insertQCon=conex.createStatement();
			String queryInsert="INSERT INTO VEHICULO values ('"+this.matricula+"', '"+this.marca+"', '"+this.modelo+"', "+this.año+", '"+this.dniCli+"')";
			System.out.println(queryInsert);
			insertQCon.execute(queryInsert);
		} catch (SQLException ex) {
			ex.getStackTrace();
			//System.out.println("Error a la hora de guardar V en la base de datos");
		}
	}
	public void actualizarBase() {
        try {
            // Conexion 
            Conexion conn = new Conexion();
            Connection conex = conn.conexOra();
            Statement updateQCon=conex.createStatement();
            String update="UPDATE VEHICULO SET marca='"+this.marca+"', modelo='"+this.modelo+"', año="+this.año+", nif_cliente='"+this.dniCli+"' WHERE matricula='"+this.matricula+"'";
            updateQCon.execute(update);
            System.out.println(update);
        } catch (SQLException ex) {
            ex.getStackTrace();
            System.out.println("Error al actualizar en la base de datos");
        }
    }
}
