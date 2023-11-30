package org.ap.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.ap.dao.ClienteDAO;
import org.ap.model.Cliente;

@ManagedBean(name = "clienteBean")
@RequestScoped
public class ClienteBean {
	
	public String nuevo() {
		Cliente c= new Cliente();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("cliente", c);
		return  "/faces/nuevo.xhtml";
	}
	
	public String guardar (Cliente cliente) {
		//guarda la fecha de registro
		Date fechaActual= new Date();
		cliente.setFregistro(new java.sql.Date(fechaActual.getTime()));
		
		ClienteDAO clienteDAO= new ClienteDAO();
		clienteDAO.guardar(cliente);
		return  "/faces/index.xhtml";
	}

	public List<Cliente> obtenerClientes() {
		ClienteDAO clienteDAO = new ClienteDAO();
		return clienteDAO.obtenerClientes(); 
	}

	public String editar(Long id) {
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente c = new Cliente();
		c = clienteDAO.buscar(id);
		System.out.println("******************************************");
		System.out.println(c);

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("cliente", c);  
		return "/faces/editar.xhtml";
	}

	public String actualizar(Cliente cliente) {
		//guarda la fecha de actualizacion
		Date fechaActual= new Date();
		cliente.setFactualizar(new java.sql.Date(fechaActual.getTime()));
		
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.editar(cliente);
		return "/faces/index.xhtml";
	}

	// eliminar un cliente
	public String eliminar(Long id) {
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.eliminar(id);
		System.out.println("Cliente eliminado..");
		return "/faces/index.xhtml";
	}

}
