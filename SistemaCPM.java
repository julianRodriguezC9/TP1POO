package sistemaCPM;

public class SistemaCPM {
	ControladorRegistro controladorRegistro = new ControladorRegistro();
	ControladorDonaciones controladorDonaciones = new ControladorDonaciones();

	public List<DonacionesUsuario> realizarBusqueda(Usuario usuario, int cantidad, LocalDate fecha, String ubicacion){
		return usuario.buscarCajas(cantidad, fecha, ubicacion, controladorDonaciones);
	}
}
