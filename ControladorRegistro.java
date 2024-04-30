package sistemaCPM;

import java.util.*;

public class ControladorRegistro {
	
	static List<Usuario> usuariosRegistrados = new ArrayList<>(); // Lista de todos los usuarios registrados.

	 // Método para enviar los datos de registro de un nuevo usuario.
	public static void enviarDatosRegistro(String nombre) {
		if(validarDatosRegistro(nombre)) {
			crearUsuario(nombre);
			mostrarMensajeExito();
		}else {
			mostrarMensajeError();
		}
	}
	
	// Método para validar los datos de registro de un nuevo usuario.
	public static boolean validarDatosRegistro(String nombre) {
		//Se valida si el nombre no es vacío 
		//Acá debería validarse lo que realmente se tiene que validar para el registro
		//(No me indicaron que es lo que se valida jajaja)
		return !nombre.isEmpty();
	}

	// Método para crear un nuevo usuario.
	public static void crearUsuario(String nombre) {
		Usuario nuevoUsuario = new Usuario(nombre);
		usuariosRegistrados.add(nuevoUsuario);
	}
	
	// Método para mostrar un mensaje de éxito después de un registro exitoso.
	private static void mostrarMensajeExito() {
		System.out.println("Registro exitoso.");
	}
	
	// Método para mostrar un mensaje de error después de un registro fallido.
	private static void mostrarMensajeError() {
		System.out.println("Error en el registro. Por favor, verifica los datos ingresados");
	}
}
