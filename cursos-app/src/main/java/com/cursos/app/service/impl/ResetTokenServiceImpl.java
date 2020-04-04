package com.cursos.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursos.app.model.ResetToken;
import com.cursos.app.repo.IResetTokenRepo;
import com.cursos.app.service.IResetTokenService;


@Service
public class ResetTokenServiceImpl implements IResetTokenService {

	@Autowired
	private IResetTokenRepo repo;
	
	@Override
	public ResetToken findByToken(String token) {
		return repo.findByToken(token);
	}

	@Override
	public void guardar(ResetToken token) {
		repo.save(token);
	}

	@Override
	public void eliminar(ResetToken token) {
		repo.delete(token);
	}

}
