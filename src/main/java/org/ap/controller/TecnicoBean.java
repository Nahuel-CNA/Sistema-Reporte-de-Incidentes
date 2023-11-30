package org.ap.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.ap.dao.TecnicoDAO;
import org.ap.model.Tecnico;

//bean gestionado por JSF (JavaServer Faces) 
@ManagedBean(name = "tecnicoBean")
@RequestScoped
public class TecnicoBean {
	

	public List<Tecnico> obtenerTecnicos() {
		TecnicoDAO TecnicoDAO = new TecnicoDAO();
		return TecnicoDAO.obtenerTecnicos(); 
	}

	

	



}
