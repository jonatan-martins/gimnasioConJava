package personas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import deportes.Deporte;

public class Usuario extends Persona implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fecNac;
    private List<Deporte> deportesInscritos = new ArrayList<>();
    private List<Deporte> deportesDisponibles;
    private static int numUsuarios;

    public Usuario(int id, String nombre, String apellido, String fecNac, List<Deporte> deportesDisponibles) {
        super(id, nombre, apellido);
        this.fecNac = fecNac;
        this.setDeportesDisponibles(deportesDisponibles);
        this.deportesInscritos = new ArrayList<>();
        numUsuarios++;
        id++;
    }

    public String getFecNac() {
        return fecNac;
    }

    public void setFecNac(String fecNac) {
        this.fecNac = fecNac;
    }

    public int getNumUsuarios() {
        return numUsuarios;
    }

    public final void setNumUsuarios(int numUsuarios) {
        Usuario.numUsuarios = numUsuarios;
    }

    public void altaDeporte(Deporte deporte) {
        if (deportesInscritos.size() < 3) {
            deportesInscritos.add(deporte);
            System.out.println("Usuario " + getNombre() + " dado de alta con éxito en " + deporte.getNombre() + "\n");
        } else {
            System.out.println("Para darte de alta en otro deporte debes darte de baja al menos en 1 de los que ya estés apuntado.\n");
        }
    }

    public void mostrarMisDeportes() {
        if (deportesInscritos.isEmpty()) {
            System.out.println("Este usuario no está dado de alta en ningún deporte.\n");
        } else {
            for (int i = 0; i < deportesInscritos.size(); i++) {
                System.out.println("Deporte " + (i + 1) + ": " + deportesInscritos.get(i).getNombre() + "\n");
            }
        }
    }

    public void bajaDeporte() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEscribe el número del deporte al que darte de baja");
        int eleccion = scanner.nextInt();
        if (eleccion > 0 && eleccion <= deportesInscritos.size()) {
            deportesInscritos.remove(eleccion - 1);
            System.out.println("Dado de baja con éxito.\n");
        } else {
            System.out.println("No tienes ningún deporte asociado a este número");
        }
    }

	public List<Deporte> getDeportesDisponibles() {
		return deportesDisponibles;
	}

	public void setDeportesDisponibles(List<Deporte> deportesDisponibles) {
		this.deportesDisponibles = deportesDisponibles;
	}

	public List<Deporte> getDeportesInscritos() {
		return deportesInscritos;
	}

	public void setDeportesInscritos(List<Deporte> deportesInscritos) {
		if (deportesInscritos != null) {
            this.deportesInscritos = deportesInscritos;
        } else {
            this.deportesInscritos = new ArrayList<>();
        }
	}

	
}
