package sistemaCPM;

import java.util.*;
import java.time.*;

public class SistemaCPM {
	ControladorRegistro controladorRegistro = new ControladorRegistro(); // Controlador para el registro de usuarios.
	ControladorDonaciones controladorDonaciones = new ControladorDonaciones(); // Controlador para las donaciones de cajas.
	
	// Método para realizar una búsqueda de cajas disponibles para una mudanza.
	public List<DonacionesUsuario> realizarBusqueda(Usuario usuario, int cantidad, LocalDate fecha, String ubicacion){
		return usuario.buscarCajas(cantidad, fecha, ubicacion, controladorDonaciones);
	}

	/*TODO: Implementar posibles métodos que permitirían que desde el sistema se hagan acciones básicas para el proceso de entrega
         y recibo de cajas*/

	public static void main(String[] args) throws Exception {
		try {
			testControladorDonaciones();
			System.out.println("Pasaron los tests");
		} catch (AssertionError e) {
			System.out.println("Fallaron los tests: " + e.getMessage());
		}
	}

	public static void testControladorDonaciones() throws Exception {
		ControladorDonaciones controlador = new ControladorDonaciones();
		controlador.donaciones = new ArrayList<>();
		LocalDate now = LocalDate.now();
		LocalDate dayAfter = now.plusDays(1);
		controlador.donarCajas(15, now, "Madrid", 2);
		List<DonacionesUsuario> encontradas = controlador.buscarCajas(2, dayAfter, "Madrid");
		assertion (encontradas != null && encontradas.stream().mapToInt(DonacionesUsuario::obtenerCantidad).sum() == 15,"Buscar cajas fallo antes de reservar.");
		controlador.reservarCajas(15, dayAfter, "Madrid");
		List<DonacionesUsuario> encontradass = controlador.buscarCajas(2, dayAfter, "Madrid");
		assertion(encontradass == null || encontradass.isEmpty(),"Buscar cajas fallo despues de reservar.");
	}


	private static void assertion(boolean condition, String message) throws AssertionError {
		if (!condition) {
			throw new AssertionError(message);
		}
	}
}
