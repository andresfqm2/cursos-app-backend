package com.cursos.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.cursos.app.model.Usuario;

public interface ILoginRepo extends JpaRepository<Usuario, Integer>{

	@Query("FROM Usuario us where us.email =:usuario")
	Usuario verificarNombreUsuario(@Param("usuario")String usuario);
	
	@Transactional
	@Modifying
	@Query("UPDATE Usuario us SET us.pass =:clave WHERE us.email =:nombre")
	void cambiarClave(@Param("clave") String clave, @Param("nombre") String nombre);
	
}
