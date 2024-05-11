package sistemaCPM;

import java.util.*;

public class ControladorRegistro {
	
	List<Usuario> usuariosRegistrados = new ArrayList<>(); // Lista de todos los usuarios registrados.

	 // Método para enviar los datos de registro de un nuevo usuario.
	public void enviarDatosRegistro(String nombre) {
		if(validarDatosRegistro(nombre)) {
			crearUsuario(nombre);
			PantallaDeTexto.mostrarTextoExito("Registro exitoso.");
		}else {
			PantallaDeTexto.mostrarTextoFallo("Error en el registro. Por favor, verifica los datos ingresados.");
		}
	}
	
	// Método para validar los datos de registro de un nuevo usuario.
	public boolean validarDatosRegistro(String nombre) {
		//Se valida si el nombre no es vacío 
		//Acá debería validarse lo que realmente se tiene que validar para el registro
		//(No me indicaron que es lo que se valida jajaja)
		return !nombre.isEmpty();
	}

	// Método para crear un nuevo usuario.
	public void crearUsuario(String nombre) {
		Usuario nuevoUsuario = new Usuario(nombre);
		usuariosRegistrados.add(nuevoUsuario);
	}
	
	
}
