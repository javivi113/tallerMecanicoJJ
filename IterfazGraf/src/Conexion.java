import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Conexion {


	private String url;
	private static Connection conex;
	private static Statement statement;
		
	public static Connection conexOra() {
		
		try{  				           	     
			// Datos para conexi�n
	        String url = "jdbc:oracle:thin:@91.200.117.27:49161:xe";       
	        Properties props = new Properties();
	        props.setProperty("user", "G3");
	        props.setProperty("password", "plaiaundi");
	              
	        // Creaci�n de conexi�n
	        conex = DriverManager.getConnection(url,props);
	        statement = conex.createStatement();
	        System.out.println("Se ha conectado");	   
		}
		catch (SQLException anException){
			while (anException != null)
			{
				System.out.println("SQL Exception:  " + anException.getMessage());
				anException = anException.getNextException();
			}
		}
		catch (java.lang.Exception anException){
			anException.printStackTrace();
		}
		
	  return conex;
	  }
	
	/*public static void main(String[] args) {
        conex=conexOra();
        try {
        	java.sql.Statement update=conex.createStatement();
        	String insert="UPDATE EMPLEADO set contrase�a='1234' where contrase�a='12345679';";
            update.execute(insert);
        } catch (SQLException e) {
            e.printStackTrace();
        }
	 }*/
}
