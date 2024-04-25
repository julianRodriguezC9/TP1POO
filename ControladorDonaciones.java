package sistemaCPM;

import java.time.*;
import java.util.*;

public class ControladorDonaciones {
	List<DonacionesUsuario> donaciones; // Lista de todas las donaciones de cajas disponibles.
	
	// Método para buscar cajas disponibles para una mudanza en una ubicación específica y en una fecha específica.
	public List<DonacionesUsuario> buscarCajas(int cantidad, LocalDate fecha, String ubicacion) {
	    List<DonacionesUsuario> donacionesDisponibles = new ArrayList<>();
	    List<DonacionesUsuario> donacionesEnUbicacion = buscarDonacionesPorUbicacion(ubicacion);
	    int cajasEncontradas = 0;
	    
	    Iterator<DonacionesUsuario> iterator = donacionesEnUbicacion.iterator();
	    while (iterator.hasNext() && cajasEncontradas < cantidad) {
	        DonacionesUsuario donacion = iterator.next();
	        if (donacion.obtenerFechaDisponibilidad().isBefore(fecha)) {
	            donacionesDisponibles.add(donacion);
	            cajasEncontradas += donacion.obtenerCantidad();
	        }
	    }
	    
	    if (cajasEncontradas < cantidad) {
	        System.out.println("No se encontraron suficientes cajas. Cajas encontradas: " + cajasEncontradas);
	        donacionesDisponibles = null;
	    }
	    
	    return donacionesDisponibles;
	}

	// Método para reservar una cantidad específica de cajas para una mudanza en una ubicación específica y en una fecha específica.
	public void reservarCajas(int cantidad, LocalDate fecha, String ubicacion) {
	    List<DonacionesUsuario> cajasParaReservar = buscarCajas(cantidad, fecha, ubicacion);
	    if(cajasParaReservar == null) {
	        System.out.println("No se pudo realizar la reserva. No hay suficientes cajas disponibles");
	        return;
	    }
	    int cajasReservadas = 0;
	    // Recorrer cada donación en la lista de cajas para reservar.
	    for(DonacionesUsuario donacion : cajasParaReservar) {
	        // Calcular cuántas cajas se van a reservar de esta donación.
	        int cajasAReservar = Math.min(donacion.obtenerCantidad(), cantidad - cajasReservadas);
	        // Si la donación tiene más cajas de las que se van a reservar, actualizar la cantidad de cajas disponibles en la donación.
	        if (cajasAReservar < donacion.obtenerCantidad()) {
	            donacion.actualizarCantidad(donacion.obtenerCantidad() - cajasAReservar);
	        } else {
	            // Si la donación tiene la cantidad exacta de cajas que se van a reservar o menos, eliminar la donación de la lista de donaciones.
	            donaciones.remove(donacion);
	        }
	        // Actualizar el total de cajas reservadas.
	        cajasReservadas += cajasAReservar;
	    }
	    System.out.println("Reserva exitosa. Cajas reservadas: " + cajasReservadas);
	}
	
	// Método para donar una cantidad específica de cajas para una mudanza en una ubicación específica y en una fecha específica.
	public void donarCajas(int cantidad, LocalDate fecha, String ubicacion, int idUsuario) {		
		DonacionesUsuario nuevaDonacion = new DonacionesUsuario(cantidad, ubicacion, fecha, idUsuario);
		donaciones.add(nuevaDonacion);
		System.out.println("Donacion exitosa. Cantidad de cajas donadas: " + cantidad);
	}
	
	// Método para buscar todas las donaciones de cajas disponibles en una ubicación específica.
	public List<DonacionesUsuario> buscarDonacionesPorUbicacion(String ubicacion){
		List<DonacionesUsuario> donacionesEnUbicacion = new ArrayList<>();
		for(DonacionesUsuario donacion : donaciones) {
			if(donacion.obtenerUbicacion().equals(ubicacion)) {
				donacionesEnUbicacion.add(donacion);
			}
		}
		return donacionesEnUbicacion;
	}
}
