import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Cliente extends Persona{
	public  String direccion, correo, usuario, contraseña;
	public  String numCuenta;
	
	//Cliente persona
	public Cliente(String nif, String nombre, String apellido1, String apellido2, int telefono, 
			String direccion, String correo, String usuario, String contraseña, String numCuenta) {
		super(nif, nombre, apellido1, apellido2, telefono);
		this.direccion=direccion;
		this.correo = correo;
		this.usuario=usuario;
		this.contraseña=contraseña; 
		this.numCuenta = numCuenta;
	}
	public Cliente(String nif, String nombre, String apellido1, String apellido2, int telefono, 
			String direccion, String correo, String numCuenta) {
		super(nif, nombre, apellido1, apellido2, telefono);
		this.direccion=direccion;
		this.correo = correo;
		this.numCuenta = numCuenta;
	}
	//Cliente empresa
	public Cliente(String nif, String nombre, int telefono,	String direccion, 
			String correo, String usuario, String contraseña, String numCuenta) {
		super(nif, nombre, telefono);
		this.direccion=direccion;
		this.correo = correo;
		this.usuario=usuario;
		this.contraseña=contraseña; 
		this.numCuenta = numCuenta;
	}
	public Cliente(String nif, String nombre, int telefono,	String direccion, 
			String correo, String numCuenta) {
		super(nif, nombre, telefono);
		this.direccion=direccion;
		this.correo = correo;
		this.numCuenta = numCuenta;
	}
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getNumCuenta() {
		return numCuenta;
	}
	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}
	
	public String toString() {
		return "INSERT INTO CLIENTE values ('"+this.nif+"', '"+this.nombre+"', "+this.apellido1+", "+this.apellido2+",'"+this.direccion+"',"+this.telefono+",'"+this.correo+"',"+this.numCuenta+","+this.usuario+","+this.contraseña+");";
	}
	public void añadirAlaBase() {
		try {
			// Conexion 
	        Conexion conn = new Conexion();
	        Connection conex = conn.conexOra();
	        Statement insertQCon=conex.createStatement();
			if(this.apellido1!=null) {
				String ap1Ins="'"+this.apellido1+"'";
				this.apellido1=ap1Ins;
				String ap2Ins="'"+this.apellido2+"'";
				this.apellido2=ap2Ins;
			}
			if (this.usuario!=null) {
				String usuIns="'"+this.usuario+"'";
				this.usuario=usuIns;
				String contrIns="'"+this.contraseña+"'";
				this.contraseña=contrIns;
			}
			String queryInsert="INSERT INTO CLIENTE values ('"+this.nif+"', '"+this.nombre+"', "+this.apellido1+", "+this.apellido2+",'"+this.direccion+"',"+this.telefono+",'"+this.correo+"',"+this.numCuenta+","+this.usuario+","+this.contraseña+")";
			insertQCon.execute(queryInsert);
			System.out.println(queryInsert);
		} catch (SQLException ex) {
			ex.getStackTrace();
			//System.out.println("Error a la hora de guardar en la base de datos");
		}
	}
	public void actualizarBase() {
        try {
            // Conexion 
            Conexion conn = new Conexion();
            Connection conex = conn.conexOra();
            Statement updateQCon=conex.createStatement();
            if(this.apellido1!=null) {
                String ap1Ins="'"+this.apellido1+"'";
                this.apellido1=ap1Ins;
                String ap2Ins="'"+this.apellido2+"'";
                this.apellido2=ap2Ins;
            }
            if (this.usuario!=null) {
                String usuIns="'"+this.usuario+"'";
                this.usuario=usuIns;
                String contrIns="'"+this.contraseña+"'";
                this.contraseña=contrIns;
            }
            String update="UPDATE CLIENTE SET nombre='"+this.nombre+"', apellido1="+this.apellido1+", apellido2="+this.apellido2+", direccion='"+this.direccion+"', telefono="+this.telefono+", correo='"+this.correo+"',n_cuenta="+this.numCuenta+",usuario="+this.usuario+",contraseña="+this.contraseña+" WHERE nif ='"+this.nif+"'";
            updateQCon.execute(update);
            System.out.println(update);
        } catch (SQLException ex) {
            ex.getStackTrace();
            System.out.println("Error al actualizar en la base de datos");
        }
    }
	
}
