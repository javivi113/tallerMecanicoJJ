

public abstract class Persona {
	public  String nif;
	public  String nombre, apellido1, apellido2;
	public  int telefono;
	public Persona(String nif, String nombre, String apellido1, String apellido2, int telefono) {
		this.nif = nif;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.telefono = telefono;
	}
	public Persona(String nif, String nombre, int telefono) {
		this.nif = nif;
		this.nombre = nombre;
		this.telefono = telefono;
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
	public abstract void añadirAlaBase();
	public abstract void actualizarBase();
}
