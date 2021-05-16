

public class Empleado extends Persona{
	public double salario;
	public int numCuenta, numSegSocial;
	
	public Empleado(String nif, String nombre, String apellido1, String apellido2, int telefono, 
			String direccion, String correo, String usuario, String contraseña, int numCuenta, double salario, int numSegSocial) {
		super(nif, nombre, apellido1, apellido2, telefono);
		this.salario= salario;
		this.numCuenta=numCuenta;
		this.numSegSocial=numSegSocial;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public int getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(int numCuenta) {
		this.numCuenta = numCuenta;
	}

	public int getNumSegSocial() {
		return numSegSocial;
	}

	public void setNumSegSocial(int numSegSocial) {
		this.numSegSocial = numSegSocial;
	}

	@Override
	public void añadirAlaBase() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarBase() {
		// TODO Auto-generated method stub
		
	}

}
