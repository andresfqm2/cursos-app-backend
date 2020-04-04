package com.cursos.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cursos.app.model.Menu;


public interface IMenuRepo extends JpaRepository<Menu, Integer>{

	@Query(value="select m.* from tbl_menu_rol mr inner join tbl_usuario_rol ur on ur.id_rol = mr.id_rol inner join tbl_menu m on m.id_menu = mr.id_menu inner join tbl_usuario u on u.id_usuario = ur.id_usuario where u.email = :nombre", nativeQuery = true)
	List<Object[]> listarMenuPorUsuario(@Param("nombre") String nombre);

}
