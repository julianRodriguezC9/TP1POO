package sistemaCPM;

import java.time.*;
import java.util.*;

public class Usuario {
	int id;
	String nombre;
	
	public Usuario(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

    public void donarCajas(int cantidad, LocalDate fecha, String ubicacion, ControladorDonaciones controlador) {
        controlador.donarCajas(cantidad, fecha, ubicacion, this.id);
    }

    public List<DonacionesUsuario> buscarCajas(int cantidad, LocalDate fecha, String ubicacion, ControladorDonaciones controlador) {
        return controlador.buscarCajas(cantidad, fecha, ubicacion);
    }
}
