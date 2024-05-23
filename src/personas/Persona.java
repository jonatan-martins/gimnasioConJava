package personas;

public abstract class Persona {
	protected static int id = 1;
	protected String nombre;
	protected String apellidos;
	
	public Persona(int id, String nombre, String apellidos) {
		Persona.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		Persona.id++;
	}
	
	public String getInfo() {
		return nombre + apellidos + " con id " + id;
	}

	public static int getId() {
		return id;
	}

	public final void setId(int id) {
		Persona.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public final void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public final void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
}