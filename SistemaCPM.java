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
}
