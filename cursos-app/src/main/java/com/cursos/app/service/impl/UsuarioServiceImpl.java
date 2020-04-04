package com.cursos.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.codec.language.bm.Lang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cursos.app.model.Rol;
import com.cursos.app.model.Usuario;
import com.cursos.app.repo.IRolRepo;
import com.cursos.app.repo.IUsuarioRepo;
import com.cursos.app.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService, UserDetailsService {

	@Autowired
	private IUsuarioRepo repo;


	@Override
	public Usuario registrar(Usuario obj) {
				
	Integer idRetornado = repo.registrar(obj.getNombre(), obj.getApellidos(), obj.getNumeroIdentificacion(), obj.getEdad(), obj.getTelefono(), obj.getEmail(), obj.getPass(), obj.getRol().getIdRol());
	
	 System.out.println("pRUE" + idRetornado);
	 return obj;
	
	}
	

	@Override
	public Usuario modificar(Usuario obj) {
		return repo.save(obj);
	}

	@Override
	public List<Usuario> listar() {
		return repo.findAll();
	}

	@Override
	public Usuario listarPorId(Integer id) {
		Optional<Usuario> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Usuario();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Usuario usuario = repo.findOneByEmail(email);

		if (usuario == null) {
			throw new UsernameNotFoundException(String.format("Usuario no existe", email));
		}

		List<GrantedAuthority> roles = new ArrayList<>();

		usuario.getRoles().forEach(rol -> {
			roles.add(new SimpleGrantedAuthority(rol.getNombre()));
		});

		UserDetails ud = new User(usuario.getEmail(), usuario.getPass(), roles);
		return ud;
	}

}
