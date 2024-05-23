package deportes;

import java.io.Serializable;

public class DeporteEquipo extends Deporte implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int jugadoresEquipo;
	private int horasSemana;
	
	public DeporteEquipo(String nombre, int anoCreacion, int jugadoresEquipo, int horasSemana) {
		super(nombre, anoCreacion);
		this.jugadoresEquipo = jugadoresEquipo;
		this.horasSemana = horasSemana;
	}
	
	@Override
	public String getInfo() {
		return super.getInfo() + "\nJugadores por equipo: " + jugadoresEquipo + "\nHoras por semana: " + horasSemana;
	}
}
