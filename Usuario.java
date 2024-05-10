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
    public void donarCajas(int cantidad, LocalDate fecha, String ubicacion) {
        ControladorDonaciones.agregarDonacion(cantidad, fecha, ubicacion, this.id);
    }

	public int obtenerId() {
		return this.id;
	}

	// Método para reservar una cantidad de cajas en base a una fecha y una ubicacion
	public void reservarCajas(int cantidad, LocalDate plusDays, String ubicacion) {
		ControladorDonaciones.reservarCajas(cantidad, plusDays, ubicacion);
		
	}
}
