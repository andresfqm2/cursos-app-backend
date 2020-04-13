package com.cursos.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursos.app.model.Curso;

public interface ICursoRepo extends JpaRepository<Curso, Integer>{

}
