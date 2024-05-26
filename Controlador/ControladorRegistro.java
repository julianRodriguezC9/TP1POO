package Controlador;

import Modelo.Usuario;
import Vista.PantallaDeTexto;

import java.util.*;

public class ControladorRegistro {
	public List<Usuario> usuariosRegistrados = new ArrayList<>();

	public void enviarDatosRegistro(String nombre) {
		if(datosRegistroValido(nombre)) {
			crearUsuario(nombre);
			PantallaDeTexto.mostrarTextoExito("Registro exitoso.");
		}else {
			PantallaDeTexto.mostrarTextoFallo("Error en el registro. Por favor, verifica los datos ingresados.");
		}
	}
	
	public boolean datosRegistroValido(String nombre) {
		return !nombre.isEmpty();
	}

	public void crearUsuario(String nombre) {
		Usuario nuevoUsuario = new Usuario(nombre);
		usuariosRegistrados.add(nuevoUsuario);
	}
}
