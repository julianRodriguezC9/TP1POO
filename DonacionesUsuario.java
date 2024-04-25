package sistemaCPM;

import java.time.*;

public class DonacionesUsuario {
	private static int nextId = 1;
	
	int id; // Identificador único de la donación.
	int cantidad; // Cantidad de cajas disponibles en la donación.
	String ubicacion; // Ubicación de la donación.
	LocalDate fechaDisponibilidad; // Fecha en la que las cajas estarán disponibles para la mudanza.
	int usuarioDonante; // Identificador del usuario que donó las cajas.
	
	// Constructor de la clase DonacionesUsuario.
	public DonacionesUsuario(int cantidad, String ubicacion, LocalDate fechaDisponibilidad, int usuarioDonante){
		this.id = nextId++;
		this.cantidad = cantidad; 
		this.ubicacion = ubicacion;
		this.fechaDisponibilidad = fechaDisponibilidad;
		this.usuarioDonante = usuarioDonante;
		}
	
	// Método para actualizar la cantidad de cajas disponibles luego de la donación. 
	public void actualizarCantidad(int nuevaCantidad) {
		this.cantidad = nuevaCantidad;
	}
	
	// Método para obtener la cantidad de cajas disponibles en la donación.
	public int obtenerCantidad() {
		return this.cantidad;
	}

	// Método para obtener la fecha en la que las cajas estarán disponibles para la mudanza.
	public LocalDate obtenerFechaDisponibilidad() {
		return this.fechaDisponibilidad;
	}

    // Método para obtener la ubicación de la donación.
	public String obtenerUbicacion() {
		return this.ubicacion;
	}
	public int obtenerId() {
		return this.id;
	}
}
