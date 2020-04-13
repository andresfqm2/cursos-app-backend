package com.cursos.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursos.app.model.Curso;
import com.cursos.app.service.ICursoService;

@RestController
@RequestMapping("/cursos")
public class CursoController {
	
	@Autowired
	private ICursoService service;
	
	@PostMapping
	public ResponseEntity<Curso>registrar(@RequestBody Curso curso){
		service.registrar(curso);
		return new ResponseEntity<Curso>(HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Curso>>listar(){
		List<Curso> ls = service.listar();
		return new ResponseEntity<List<Curso>>(ls, HttpStatus.OK);
	}
	
	@GetMapping("/pageable")
	public ResponseEntity<Page<Curso>> listarPageable(Pageable pageable) {
		Page<Curso> cursos = service.listarPageable(pageable);
		return new ResponseEntity<Page<Curso>>(cursos, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object>eliminar(@PathVariable("id") Integer id){
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	
	

}
