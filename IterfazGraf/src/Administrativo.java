

public class Administrativo extends Empleado {
	public String tipo;
	public Administrativo(String nif, String nombre, String apellido1, String apellido2, int telefono, 
			String direccion, String correo, String usuario, String contrase�a, int numCuenta, double salario, int numSegSocial, String tipo) {
		super(nif, nombre, apellido1, apellido2, telefono, direccion, correo, usuario, contrase�a, numCuenta, salario, numSegSocial);
		this.tipo=tipo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
