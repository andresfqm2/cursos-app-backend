package com.cursos.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cursos.app.model.Usuario;
import com.cursos.app.service.IUsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private IUsuarioService service;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;

	@PostMapping
	public ResponseEntity<Object> registrar(@RequestBody Usuario usuario) {
		
		usuario.setPass(bcrypt.encode(usuario.getPass()));
		
		service.registrar(usuario);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Usuario>modificar(@RequestBody Usuario usuario){
		Usuario al = service.modificar(usuario);
		return new ResponseEntity<Usuario>(al, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Usuario>> listar() {
		List<Usuario> ls = service.listar();
		return new ResponseEntity<List<Usuario>>(ls, HttpStatus.OK);

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> listarPorId(@PathVariable("id") Integer id){
		Usuario al = service.listarPorId(id);
		return new ResponseEntity<Usuario>(al, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object>eliminar(@PathVariable("id") Integer id){
		 service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

}
