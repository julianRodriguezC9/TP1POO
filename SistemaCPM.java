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
			System.out.println("-----------------------------------------------");
			testUsuariosYDonaciones();
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

	public static void testUsuariosYDonaciones() throws Exception {
	    // Crear el sistema.
	    SistemaCPM sistema = new SistemaCPM();

	    // Crear a Sarah Connor y hacer que done 10 cajas.
	    Usuario sarahConnor = new Usuario("Sarah Connor");
	    sarahConnor.donarCajas(10, LocalDate.now(), "Almagro", sistema.controladorDonaciones);
	    System.out.println(sarahConnor.nombre + " ya donó");
	    // Crear a Charles Leclerc y hacer que done 5 cajas.
	    Usuario charlesLeclerc = new Usuario("Charles Leclerc");
	    charlesLeclerc.donarCajas(5, LocalDate.now(), "Almagro", sistema.controladorDonaciones);
	    System.out.println(charlesLeclerc.nombre + " ya donó");
	    // Crear a Elen Ripley y hacer que busque las cajas que le sirven.
	    Usuario elenRipley = new Usuario("Elen Ripley");
	    
	    // Hacer que Elen Ripley reserve las 13 cajas (al reservar las cajas ya se buscan...).
	    elenRipley.reservarCajas(13, LocalDate.now().plusDays(1), "Almagro", sistema.controladorDonaciones);
	    
	    // Verificar que la donación de Sarah Connor ya no está en el sistema (Elen se la llevó).
	    if (sistema.controladorDonaciones.donaciones.stream().noneMatch(d -> d.usuarioDonante == sarahConnor.id)) {
	        System.out.println("Prueba exitosa: La donación de Sarah Connor ya no está en el sistema.");
	    } else {
	        System.out.println("Prueba fallida: La donación de Sarah Connor todavía está en el sistema.");
	    }

	    // Verificar que la donación de Charles Leclerc tiene la cantidad correcta de cajas (2 cajas) (Elen se llevó 3).
	    DonacionesUsuario donacionCharles = sistema.controladorDonaciones.donaciones.stream().filter(d -> d.usuarioDonante == charlesLeclerc.id).findFirst().orElse(null);
	    if (donacionCharles != null && donacionCharles.obtenerCantidad() == 2) {
	        System.out.println("Prueba exitosa: La donación de Charles Leclerc tiene la cantidad correcta de cajas (2 cajas) en el sistema.");
	    } else {
	        System.out.println("Prueba fallida: La donación de Charles Leclerc tiene " + (donacionCharles != null ? donacionCharles.obtenerCantidad() : "N/A") + " cajas.");
	    }
	}
}
