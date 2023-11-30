package org.ap.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.ap.dao.OrdenDAO;
import org.ap.model.Orden;

@ManagedBean(name = "ordenBean") // bean manejado por JSF con el nombre "ordenBean
@RequestScoped //Define el alcance del bean, limitado al ámbito de una solicitud HTTP.
public class OrdenBean {
	
	public String nuevo() {
		Orden c= new Orden();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("orden", c);
		return  "/faces/nuevoorden.xhtml"; //cambiar por uno nuevo
	}
	
	public String guardar (Orden orden) {
		//guarda la fecha de registro
		Date fechaActual= new Date();
		orden.setForden(new java.sql.Date(fechaActual.getTime()));
		
		OrdenDAO ordenDAO= new OrdenDAO();
		ordenDAO.guardar(orden);
		return  "/faces/index.xhtml";  
	}

	public List<Orden> obtenerOrdenes() {
		OrdenDAO ordenDAO = new OrdenDAO();
		return ordenDAO.obtenerOrdenes(); 
	}

	public String editar(Long id) {
		OrdenDAO ordenDAO = new OrdenDAO();
		Orden c = new Orden();
		c = ordenDAO.buscar(id);
		System.out.println("******************************************");
		System.out.println(c);

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("orden", c);  
		return "/faces/editarorden.xhtml";   //cambiar por uno nuevo
	}

	public String actualizar(Orden orden) {
		/*//guarda la fecha de actualizacion
		Date fechaActual= new Date();
		cliente.setFactualizar(new java.sql.Date(fechaActual.getTime()));*/
		
		OrdenDAO ordenDAO = new OrdenDAO();
		ordenDAO.editar(orden);
		return "/faces/index.xhtml";
	}

	// eliminar un cliente
	public String eliminar(Long id) {
		OrdenDAO ordenDAO = new OrdenDAO();
		ordenDAO.eliminar(id);
		System.out.println("Cliente eliminado..");
		return "/faces/index.xhtml";
	}

}
