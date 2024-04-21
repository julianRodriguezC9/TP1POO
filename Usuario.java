package sistemaCPM;

import java.time.*;
import java.util.*;

public class Usuario {
	int id;
	String nombre;
	ControladorDonaciones controlador;
	
	public Usuario(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

    public void donarCajas(int cantidad, LocalDate fecha, String ubicacion) {
        controlador.donarCajas(cantidad, fecha, ubicacion, this.id);
    }

    public List<DonacionesUsuario> buscarCajas(int cantidad, LocalDate fecha, String ubicacion) {
        return controlador.buscarCajas(cantidad, fecha, ubicacion);
    }
}
