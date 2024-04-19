package sistemaCPM;

import java.time.*;
import java.util.*;

public class ControladorDonaciones {
	List<DonacionesUsuario> donaciones;
	
	public List<DonacionesUsuario> buscarCajas(int cantidad, LocalDate fecha, String ubicacion) {
		List<DonacionesUsuario> cajasDisponibles = new ArrayList<>();
		int cajasEncontradas = 0;
		Iterator<DonacionesUsuario> iterator = donaciones.iterator();
		
		while(iterator.hasNext() && cajasEncontradas < cantidad) {
			DonacionesUsuario donacion = iterator.next();
			if(donacion.obtenerFechaDisponibilidad().isAfter(fecha) && donacion.obtenerUbicacion().equals(ubicacion)) {
				cajasDisponibles.add(donacion);
				cajasEncontradas += donacion.obtenerCantidad();
			}
		}
		if(cajasEncontradas < cantidad) {
			System.out.println("No se encontraron suficientes cajas. Cajas encontradas: " + cajasEncontradas);
			cajasDisponibles = null;
		}
		return cajasDisponibles;
	}
	
	/*Problema con este tipo de implementación, según el diagrama el tema es que el método reservarCajas
	 *Se ejecuta luego de que buscarCajas buscara exitosamente cajas y las devolviera en forma de lista
	 *El problema surge en que el reservarCajas trabajaría con las cajas de donaciones (variable de
	 *la instancia) y no sobre la lista de cajas que se envío en el anterior método, por lo que toca
	 *analizar reservarCajas sobre como procederá
	 */
	
	public void reservarCajas(int cantidad, LocalDate fecha, String ubicacion) {
		//Sin probar
		List<DonacionesUsuario> cajasParaReservar = buscarCajas(cantidad, fecha, ubicacion);
		if(cajasParaReservar == null) {
			System.out.println("No se pudo realizar la reserva. No hay suficientes cajas disponibles");
			return;
			}
		int cajasReservadas = 0;
		for(DonacionesUsuario donacion : cajasParaReservar) {
			if(donacion.obtenerCantidad() >= (cantidad - cajasReservadas)) {
				int cajasAReservar = cantidad - cajasReservadas;
				cajasReservadas += cajasAReservar;
			}else {
				cajasReservadas += donacion.obtenerCantidad();
				donacion.actualizarCantidad(0);
			}
		}
		System.out.println("Reserva exitosa. Cajas reservadas: " + cajasReservadas);
	}
	
	public void donarCajas(int cantidad, LocalDate fecha, String ubicacion, int idUsuario) {		
		DonacionesUsuario nuevaDonacion = new DonacionesUsuario(cantidad, ubicacion, fecha, idUsuario);
		donaciones.add(nuevaDonacion);
		System.out.println("Donacion exitosa. Cantidad de cajas donadas: " + cantidad);
	}
}
