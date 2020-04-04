package com.cursos.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursos.app.model.Usuario;
import com.cursos.app.repo.ILoginRepo;
import com.cursos.app.service.ILoginService;

@Service
public class LoginServiceImpl implements ILoginService{

	@Autowired
	private ILoginRepo repo;

	@Override
	public Usuario verificarNombreUsuario(String usuario) {
		return repo.verificarNombreUsuario(usuario);
	}

	@Override
	public void cambiarClave(String clave, String nombre) {
		repo.cambiarClave(clave, nombre);
	}
	

}
