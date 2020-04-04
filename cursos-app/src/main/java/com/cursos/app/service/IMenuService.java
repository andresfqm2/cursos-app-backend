package com.cursos.app.service;

import java.util.List;

import com.cursos.app.model.Menu;


public interface IMenuService extends ICRUD<Menu, Integer>{
	
	List<Menu> listarMenuPorUsuario(String nombre);

}
