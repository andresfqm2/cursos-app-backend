package com.cursos.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cursos.app.model.Alumno;
import com.cursos.app.service.IAlumnoService;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

	@Autowired
	private IAlumnoService service;

	@PostMapping
	public ResponseEntity<Alumno> registrar(@RequestBody Alumno alumno) {
		Alumno al = service.registrar(alumno);
		return new ResponseEntity<Alumno>(al, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Alumno>modificar(@RequestBody Alumno alumno){
		Alumno al = service.modificar(alumno);
		return new ResponseEntity<Alumno>(al, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Alumno>> listar() {
		List<Alumno> ls = service.listar();
		return new ResponseEntity<List<Alumno>>(ls, HttpStatus.OK);

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Alumno> listarPorId(@PathVariable("id") Integer id){
		Alumno al = service.listarPorId(id);
		return new ResponseEntity<Alumno>(al, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object>eliminar(@PathVariable("id") Integer id){
		 service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

}
