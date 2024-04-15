package sistemaCPM;

import java.time.*;
import java.util.*;

public class ControladorDonaciones {
	List<DonacionesUsuario> donaciones;
	
	public List<DonacionesUsuario> buscarCajas(int cantidad, LocalDate fecha, String ubicacion) {
		List<DonacionesUsuario> cajasDisponibles = new ArrayList<>();
		
		for(DonacionesUsuario donacion : donaciones) {
			if(donacion.cantidad >= cantidad && donacion.fechaDisponibilidad.isAfter(fecha) && donacion.ubicacion.equals(ubicacion)) {
				cajasDisponibles.add(donacion);
			}
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
		//TODO
	}
	
	public void donarCajas(int cantidad, LocalDate fecha, String ubicacion, int idUsuario) {
		//TODO
	}
}
