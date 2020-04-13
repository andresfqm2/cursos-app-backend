package com.cursos.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cursos.app.model.Curso;

public interface ICursoService extends ICRUD<Curso, Integer>{

	Page<Curso> listarPageable(Pageable pageable);
}
