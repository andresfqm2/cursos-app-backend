package com.cursos.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursos.app.model.ResetToken;


public interface IResetTokenRepo extends JpaRepository<ResetToken, Integer>{
	
	//from ResetToken rt where rt.token = :?
	ResetToken findByToken(String token);

}
