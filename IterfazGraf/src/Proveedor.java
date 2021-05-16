

public class Proveedor extends Persona{
	public String comercio;
	public Proveedor(String nif, String nombre, String apellido1, String apellido2, int telefono, String comercio) {
		super(nif, nombre, apellido1, apellido2, telefono);
		this.comercio=comercio;
	}
	public Proveedor(String nif, String nombre, int telefono, String comercio) {
		super(nif, nombre, telefono);
		this.comercio=comercio;
	}
	public String getComercio() {
		return comercio;
	}
	public void setComercio(String comercio) {
		this.comercio = comercio;
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
