package sistemaCPM;

import java.time.*;
import java.util.*;

public class Usuario {
	private static int nextId = 1;
	int id; // Identificador único del usuario.
	String nombre; // Nombre del usuario.
 
	// Constructor de la clase Usuario.
	public Usuario(String nombre) {
		this.id = nextId++;
		this.nombre = nombre;
	}
	
	// Método para donar una cantidad específica de cajas para una mudanza.
    public void donarCajas(int cantidad, LocalDate fecha, String ubicacion, ControladorDonaciones controlador) {
        controlador.donarCajas(cantidad, fecha, ubicacion, this.id);
    }

    // Método para buscar una cantidad específica de cajas para una mudanza.
    public List<DonacionesUsuario> buscarCajas(int cantidad, LocalDate fecha, String ubicacion, ControladorDonaciones controlador) {
        return controlador.buscarCajas(cantidad, fecha, ubicacion);
    }
}
