package org.ap.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


import org.ap.model.JPAUtil;
import org.ap.model.Orden;

public class OrdenDAO {
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

	// guardar orden
	public void guardar(Orden orden) {
		entity.getTransaction().begin();
		entity.persist(orden);
		entity.getTransaction().commit();
		//JPAUtil.shutdown(); cierra la conexion
	}

	// editar orden
	public void editar(Orden orden) {
		entity.getTransaction().begin();
		entity.merge(orden);
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
	}

	// buscar orden
	public Orden buscar(Long id) {
		Orden c = new Orden();
		c = entity.find(Orden.class, id);
		//JPAUtil.shutdown();
		return c;
	}

  	/// eliminar orden
	public void eliminar(Long id) {
		Orden c = new Orden();
		c = entity.find(Orden.class, id);
		entity.getTransaction().begin();
		entity.remove(c);
		entity.getTransaction().commit();
	}

	// obtener todos las ordenes
	public List<Orden> obtenerOrdenes() {
		List<Orden> listaOrdenes = new ArrayList<>();
		Query q = entity.createQuery("SELECT c FROM Orden c");
		listaOrdenes = q.getResultList();
		return listaOrdenes;
	}
  
}  
