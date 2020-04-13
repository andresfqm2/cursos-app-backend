package com.cursos.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cursos.app.model.Curso;
import com.cursos.app.repo.ICursoRepo;
import com.cursos.app.service.ICursoService;

@Service
public class CursoServiceImpl implements ICursoService{

	@Autowired
	private ICursoRepo repo;
	
	@Override
	public Curso registrar(Curso obj) {
		return repo.save(obj);
	}

	@Override
	public Curso modificar(Curso obj) {
		return repo.save(obj);
	}

	@Override
	public List<Curso> listar() {
		return repo.findAll();
	}

	@Override
	public Curso listarPorId(Integer id) {
		Optional<Curso> c = repo.findById(id);		
		return c.isPresent() ? c.get() : new Curso();
	}
	
	@Override
	public Page<Curso> listarPageable(Pageable pageable) {
		return repo.findAll(pageable);
	}


	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
