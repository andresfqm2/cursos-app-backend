package com.cursos.app;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cursos.app.model.Rol;
import com.cursos.app.model.Usuario;
import com.cursos.app.repo.IUsuarioRepo;


@SpringBootTest
class VentasApp1ApplicationTests {

	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Autowired
	private IUsuarioRepo repo;
	
	@Test
	void crearUsuario() {
		Usuario us = new Usuario();
		Rol rol = new Rol();
		rol.setIdRol(1);
		
		us.setIdUsuario(33);
		us.setNombre("Andres");
		us.setApellidos("Quintana");
		us.setEdad(29);
		us.setNumeroIdentificacion("1013456210");
		us.setTelefono("3124326789");
		us.setEmail("andrescable@hotmail.com");
		us.setPass(bcrypt.encode("Tempo123#$"));
		us.setRol(rol);
	
		
		Usuario retorno = repo.save(us);
		
		assertTrue(retorno.getPass().equalsIgnoreCase(us.getPass()));
	}

}
