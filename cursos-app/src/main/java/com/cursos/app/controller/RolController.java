package com.cursos.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursos.app.model.Rol;
import com.cursos.app.service.impl.RolServiceImpl;

@RestController
@RequestMapping("/roles")
public class RolController {

	@Autowired
	private RolServiceImpl service;
	
	@GetMapping
	public ResponseEntity<List<Rol>> listar() {
		List<Rol> ls = service.listar();
		return new ResponseEntity<List<Rol>>(ls, HttpStatus.OK);
	}
}
