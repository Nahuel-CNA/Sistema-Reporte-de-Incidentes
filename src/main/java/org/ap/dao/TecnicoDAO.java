package org.ap.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.ap.model.JPAUtil;
import org.ap.model.Tecnico;

public class TecnicoDAO {
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

	// buscar tecnico
	public Tecnico buscar(Long id) {
		Tecnico c = new Tecnico();
		c = entity.find(Tecnico.class, id);
		//JPAUtil.shutdown();
		return c;
	}

  	

	// obtener todos los tecnicos
	public List<Tecnico> obtenerTecnicos() {
		List<Tecnico> listaTecnicos = new ArrayList<>();
		Query q = entity.createQuery("SELECT c FROM Tecnico c");
		listaTecnicos = q.getResultList();
		return listaTecnicos;
	}
  
}  
