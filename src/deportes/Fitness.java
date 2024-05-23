package deportes;

import java.io.Serializable;

public class Fitness extends Deporte implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String intensidad;
	private int maxAlumnos;
	
	public Fitness(String nombre, int anoCreacion, String intensidad, int maxAlumnos) {
		super(nombre,anoCreacion);
		if(intensidad.equals("Alta") || intensidad.equals("Media") || intensidad.equals("Baja")) {
			this.intensidad = intensidad;
		}
		this.maxAlumnos = maxAlumnos;
	}
	
	@Override
	public String getInfo() {
		return super.getInfo() + "\nGrado de intensidad: " + intensidad + "\nNúmero máximo de alumnos: " + maxAlumnos;
	}
}