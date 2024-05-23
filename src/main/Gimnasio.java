package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import deportes.*;
import personas.*;

public class Gimnasio {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // creo deportes
        List<Deporte> deportes = new ArrayList<>();
        deportes.add(new Fitness("Powerlifting", 1950, "Alta", 10));
        deportes.add(new Fitness("Bodybuilding", 1900, "Media", 15));
        deportes.add(new DeporteIndividual("Natación", 1896, "Piscina", "indoor"));
        deportes.add(new DeporteIndividual("Tenis", 1873, "Raqueta", "outdoor"));
        deportes.add(new DeporteEquipo("Baloncesto", 1891, 5, 10));
        deportes.add(new DeporteEquipo("Waterpolo", 1880, 7, 8));
        try {
        	ObjectOutputStream streamSerial = new ObjectOutputStream(new FileOutputStream("G:\\Mi unidad\\CFGS - DAW\\[PROG] Programación\\Tema 9\\Tarea9.2prog\\deportesOferetados.txt"));
        	streamSerial.writeObject(deportes);
        	streamSerial.close();
        } catch(IOException e) {
        	e.printStackTrace();
        	System.out.println("No se tienen permisos de lectura o escritura o el archivo está dañado");
        }

        List<Empleado> empleados = new ArrayList<>();
        empleados.add(new Empleado(Persona.getId(), "Jonatan", "Martins do Vale", "DaW2024"));//aqui está la contraseña

        boolean contrasenaCorrecta = false;
        String pruebaContrasena;
        while (!contrasenaCorrecta) {
            System.out.println("Introduzca la contraseña del Empleado 1: " + empleados.get(0).getNombre() + "(DaW2024)");
            pruebaContrasena = scanner.next();
            if (pruebaContrasena.equals(empleados.get(0).getContrasena())) {
                System.out.println("Contraseña correcta...\nUsuario: " + empleados.get(0).getNombre() + " " + empleados.get(0).getApellidos() + "\nIniciando sesion...");
                contrasenaCorrecta = true;
            } else {
                System.out.println("Contraseña incorrecta.");
            }
        }

        System.out.println("¿Cuántos usuarios quieres crear?");
        int crearUsuarios = scanner.nextInt();
        List<Usuario> usuarios = new ArrayList<>();

        for (int i = 0; i < crearUsuarios; i++) { // Esto es para crear los usuarios
            System.out.println("¿Qué nombre tiene el usuario " + (i + 1) + "?");
            scanner.nextLine(); // es para consumir la linea nueva pendiente ya que me daba error
            String nombre = scanner.nextLine();
            System.out.println("¿Cuáles son sus apellidos?");
            String apellidos = scanner.nextLine();
            System.out.println("¿Cuál es su fecha de nacimiento?");
            String fecha = scanner.next();
            usuarios.add(new Usuario(Persona.getId(), nombre, apellidos, fecha, deportes));
        }

        // estas variables las utilizo para que el programa sea dinámico y pueda rellenar los atributos necesarios para cada método con ellas
        boolean salir = false; // sirve para salir del programa
        int accion; // sirve para saber qué numero del menú ha elegido el empleado
        int usuario; // sirve para saber a qué usuario se refiere
        int deporte;
        int total;
        do {
            // esto es un menú para que el usuario pueda elegir que accion realizará
            System.out.println("Pantalla principal:\n\nQUÉ ACCIÓN QUIERES REALIZAR?"
            		+ "\n1: Mostrar los deportes disponibles"
            		+ "\n2: Dar de alta a un usuario en algún deporte"
            		+ "	\n3: Dar de baja a un usuario en algún deporte"
            		+ "\n4: Mostrar los deportes de algún usuario"
            		+ "\n5: Guardar deportes de algún usuario"
            		+ "\n6: Recuperar deportes de algún usuario"
            		+ "\n7: Salir");
            accion = scanner.nextInt();

            // esto sirve para mostrar los deportes a los que se puede apuntar cualquier usuario
            if (accion == 1) {
                mostrarDeportes(deportes);

                // esto sirve para dar de alta a cualquier usuario en 1, 2 o 3 deportes
            } else if (accion == 2) {
                System.out.println("¿A cuál usuario quieres dar de alta en algún deporte?");
                for (int i = 0; i < usuarios.size(); i++) {
                    System.out.println("Usuario " + (i + 1) + ": " + usuarios.get(i).getNombre());
                }
                usuario = scanner.nextInt() - 1;
                System.out.println("¿A cuántos deportes quieres darle de alta?\nComo máximo puedes darle de alta a 3 deportes.");
                total = scanner.nextInt();
                System.out.println("Los deportes disponibles son los siguientes:");
                mostrarDeportes(deportes);
                for (int i = 0; i < total; i++) {
                    System.out.println("Deporte " + (i + 1) + ": ¿A qué deporte quieres darle de alta?");
                    deporte = scanner.nextInt() - 1;
                    usuarios.get(usuario).altaDeporte(deportes.get(deporte));
                }

                // esto sirve para dar de baja a cualquier usuario de cualquier deporte
            } else if (accion == 3) {
                System.out.println("¿A cuál usuario quieres dar de baja en algún deporte?");
                for (int i = 0; i < usuarios.size(); i++) {
                    System.out.println("Usuario " + (i + 1) + ": " + usuarios.get(i).getNombre());
                }
                usuario = scanner.nextInt() - 1;
                System.out.println("Los deportes a los que este usuario está dado de alta son los siguientes:");
                usuarios.get(usuario).mostrarMisDeportes();
                usuarios.get(usuario).bajaDeporte();

                // esto sirve para ver los deportes a los que está apuntado cualquier usuario
            } else if (accion == 4) {
                System.out.println("¿De qué usuario quieres ver los deportes?");
                for (int i = 0; i < usuarios.size(); i++) {
                    System.out.println("Usuario " + (i + 1) + ": " + usuarios.get(i).getNombre());
                }
                usuario = scanner.nextInt() - 1;
                usuarios.get(usuario).mostrarMisDeportes();

                // esto sirve para salir del programa
            } else if (accion == 5) {
                System.out.println("¿De qué usuario quieres guardar los deportes?");
                for (int i = 0; i < usuarios.size(); i++) {
                    System.out.println("Usuario " + (i + 1) + ": " + usuarios.get(i).getNombre());
                }
                usuario = scanner.nextInt() - 1;
                guardarDeportesApuntados(usuarios.get(usuario));
                
            } else if (accion == 6) {
                System.out.println("¿Sobre qué usuario quieres recuperar los deportes?");
                for (int i = 0; i < usuarios.size(); i++) {
                    System.out.println("Usuario " + (i + 1) + ": " + usuarios.get(i).getNombre());
                }
                usuario = scanner.nextInt() - 1;
                recuperarDeportesGuardados(usuarios.get(usuario));
                
            }else if (accion == 7) {
                System.out.println("Saliendo...");
                salir = true;
            } else {
                System.out.println("Error. Por favor, elija una opción válida.");
            }

        } while (!salir);

        System.out.println("Programa cerrado correctamente.");
    }

    public static void mostrarDeportes(List<Deporte> deportes) {
        for (int i = 0; i < deportes.size(); i++) {
            System.out.println("Deporte " + (i + 1) + ": " + deportes.get(i).getInfo() + "\n");
        }
    }
    
    public static void guardarDeportesApuntados(Usuario usuario) {
        String nombreArchivo = "G:\\Mi unidad\\CFGS - DAW\\[PROG] Programación\\Tema 9\\Tarea9.2prog\\" + usuario.getNombre() + "_" + usuario.getApellidos() + ".txt";
        try {
        	ObjectOutputStream streamSerial = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
        	Deporte[] deportes = new Deporte[usuario.getDeportesInscritos().size()];
            usuario.getDeportesInscritos().toArray(deportes);
        	streamSerial.writeObject(deportes);
        	streamSerial.close();
            System.out.println("Deportes guardados con éxito en " + nombreArchivo + "\n");
        } catch (IOException e) {
            System.out.println("Error: No se pueden guardar los deportes");
            e.printStackTrace();
        }
    }

    
    public static void recuperarDeportesGuardados(Usuario usuario) {
    	String nombreArchivo = "G:\\Mi unidad\\CFGS - DAW\\[PROG] Programación\\Tema 9\\Tarea9.2prog\\" + usuario.getNombre() + "_" + usuario.getApellidos() + ".txt";
    	try {
            ObjectInputStream streamRecup = new ObjectInputStream(new FileInputStream(nombreArchivo));
            Deporte[] deportes = (Deporte[]) streamRecup.readObject();
            streamRecup.close();
            for (Deporte deporte : deportes) {
                    usuario.altaDeporte(deporte);
            }
           
            System.out.println("Deportes recuperados con éxito para el usuario " + usuario.getNombre() + " " + usuario.getApellidos() + "\n");
        } catch (FileNotFoundException e) {
            System.out.println("Error: No se puede encontrar el archivo");
        } catch (IOException e) {
            System.out.println("Error: No se tienen permisos de lectura o escritura o el archivo está dañado");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Clase no encontrada durante la deserialización");
            e.printStackTrace();
        } catch ( NullPointerException e) {
        	System.out.println("No tiene lista válida o descerializacion fallida");
        }
    }
    
}
