package com.cursos.app.service;

import com.cursos.app.model.Usuario;

public interface ILoginService {

	Usuario verificarNombreUsuario(String usuario);
	void cambiarClave(String clave, String nombre);
}

