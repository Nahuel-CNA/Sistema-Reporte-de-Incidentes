package org.ap.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.ap.dao.CategoriaDAO;
import org.ap.dao.ClienteDAO;
import org.ap.model.Categoria;


@ManagedBean(name = "categoriaBean")
@RequestScoped
public class CategoriaBean {
	
	public String nuevo() {
		Categoria c= new Categoria();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("categoria", c);
		return  "/faces/nuevo.xhtml";
	}
	
	public String guardar (Categoria categoria) {
	
		
		CategoriaDAO categoriaDAO= new CategoriaDAO();
		categoriaDAO.guardar(categoria);
		return  "/faces/index.xhtml";
	}

	public List<Categoria> obtenerCategorias() {
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		return categoriaDAO.obtenerCategorias(); 
	}

	public String editar(Long id) {
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		Categoria c = new Categoria();
		c = categoriaDAO.buscar(id);
		System.out.println("******************************************");
		System.out.println(c);

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("categoria", c);  
		return "/faces/editar.xhtml";
	}

	public String actualizar(Categoria categoria) {
		
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		categoriaDAO.editar(categoria);
		return "/faces/index.xhtml";
	}

	// eliminar un cliente
	public String eliminar(Long id) {
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		categoriaDAO.eliminar(id);
		System.out.println("Cliente eliminado..");
		return "/faces/index.xhtml";
	}

}
