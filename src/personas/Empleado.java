package personas;

public class Empleado extends Persona{
	private String contrasena;
	private static int numEmpleados;
	
	public Empleado(int id, String nombre, String apellido, String contrasena) {
		super(id, nombre, apellido);
		this.contrasena = contrasena;
		numEmpleados++;
		id++;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public int getNumEmpleados() {
		return numEmpleados;
	}

	public final void setNumEmpleados(int numEmpleados) {
		this.numEmpleados = numEmpleados;
	}
	
}