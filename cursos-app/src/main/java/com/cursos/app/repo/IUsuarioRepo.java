package com.cursos.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cursos.app.model.Rol;
import com.cursos.app.model.Usuario;

public interface IUsuarioRepo extends JpaRepository<Usuario, Integer> {
	//select * from usuario where email = ?
	Usuario findOneByEmail(String email);
	
	//@Transactional
	//@Modifying
	@Query(value = "SELECT crearUsuario(:nombre, :apellidos, :numeroIdentificacion, :edad, :telefono, :email, :pass, :idRol)", nativeQuery = true)
	Integer registrar(@Param("nombre") String nombre, @Param("apellidos") String apellidos, @Param("numeroIdentificacion") String numeroIdentificacion,  @Param("edad") Integer edad, @Param("telefono") String telefono, @Param("email") String email, @Param("pass") String pass, @Param("idRol") Integer idRol);

}
