package sistemaCPM;

import java.time.*;

public class DonacionesUsuario {
	int id;
	int cantidad;
	String ubicacion;
	LocalDate fechaDisponibilidad;
	int usuarioDonante;
	
	public void actualizarCantidad(int nuevaCantidad) {
		this.cantidad = nuevaCantidad;
	}
}
