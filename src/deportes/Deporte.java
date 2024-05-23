package deportes;

import java.io.Serializable;

public abstract class Deporte implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String nombre;
	protected int anoCreacion;
	
    public Deporte(String nombre, int anoCreacion) {
        this.nombre = nombre;
        this.anoCreacion = anoCreacion;
    }
	
	public String getInfo() {
		return "El deporte es " + nombre +  " y su año de creación fue en " + anoCreacion;
	}

	public String getNombre() {
		return nombre;
	}

	public final void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAño() {
		return anoCreacion;
	}

	public final void setAño(int anoCreacion) {
		this.anoCreacion = anoCreacion;
	}
}