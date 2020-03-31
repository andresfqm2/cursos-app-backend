package com.cursos.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursos.app.model.Alumno;

public interface IAlumnoRepo extends JpaRepository<Alumno, Integer> {

}
