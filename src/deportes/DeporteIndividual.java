package deportes;

import java.io.Serializable;

public class DeporteIndividual extends Deporte implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String material;
	private String lugar;
	
	public DeporteIndividual(String nombre, int anoCreacion, String material, String lugar) {
		super(nombre, anoCreacion);
		this.material = material;
		if(lugar == "indoor" || lugar == "outdoor") {
			this.lugar = lugar;
		}
		
	}
	
	@Override
	public String getInfo() {
		return super.getInfo() + "\nMaterial principal: " + material + "\nLugar de realización: " + lugar;
	}
}