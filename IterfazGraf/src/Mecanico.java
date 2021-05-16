

public class Mecanico extends Empleado{
	public String tipo;
	public boolean disponible;
	public Mecanico(String nif, String nombre, String apellido1, String apellido2, int telefono, 
			String direccion, String correo, String usuario, String contraseña, int numCuenta, double salario, int numSegSocial, String tipo, boolean disponible) {
		super(nif, nombre, apellido1, apellido2, telefono, direccion, correo, usuario, contraseña, numCuenta, salario, numSegSocial);
		this.tipo=tipo;
		this.disponible=disponible;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

}
