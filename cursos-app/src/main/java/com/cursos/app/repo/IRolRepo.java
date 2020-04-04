package com.cursos.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cursos.app.model.Rol;

public interface IRolRepo extends JpaRepository<Rol, Integer>{

	@Query(value = "SELECT r.id_rol, r.descripcion, r.nombre FROM tbl_usuario_rol  ur INNER JOIN tbl_rol r ON ur.id_rol = r.id_rol WHERE id_usuario =:idUsuario", nativeQuery = true)
	List<Rol> listaRoles(@Param("idUsuario") Integer idUsuario);

	
}
