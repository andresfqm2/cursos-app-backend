package com.cursos.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursos.app.model.Rol;
import com.cursos.app.repo.IRolRepo;
import com.cursos.app.service.IRolService;

@Service
public class RolServiceImpl implements IRolService{

	@Autowired
	private IRolRepo repo;
	
	@Override
	public Rol registrar(Rol obj) {
		return repo.save(obj);
	}

	@Override
	public Rol modificar(Rol obj) {
		return repo.save(obj);
	}

	@Override
	public List<Rol> listar() {
		return repo.findAll();
	}

	@Override
	public Rol listarPorId(Integer id) {
		Optional<Rol> rl = repo.findById(id);
		return rl.isPresent()? rl.get() : new Rol();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
