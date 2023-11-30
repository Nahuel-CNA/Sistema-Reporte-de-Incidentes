package org.ap.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.ap.model.Categoria;
import org.ap.model.JPAUtil;

public class CategoriaDAO {
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

	// guardar categoria
	public void guardar(Categoria categoria) {
		entity.getTransaction().begin();
		entity.persist(categoria);
		entity.getTransaction().commit();
		//JPAUtil.shutdown(); cierra la conexion
	}

	// editar categoria
	public void editar(Categoria categoria) {
		entity.getTransaction().begin();
		entity.merge(categoria);
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
	}

	// buscar categoria
	public Categoria buscar(Long id) {
		Categoria c = new Categoria();
		c = entity.find(Categoria.class, id);
		//JPAUtil.shutdown();
		return c;
	}

  	/// eliminar categoria
	public void eliminar(Long id) {
		Categoria c = new Categoria();
		c = entity.find(Categoria.class, id);
		entity.getTransaction().begin();
		entity.remove(c);
		entity.getTransaction().commit();
	}

	// obtener todos las categorias
	public List<Categoria> obtenerCategorias() {
		List<Categoria> listaCategorias = new ArrayList<>();
		Query q = entity.createQuery("SELECT c FROM Categoria c");
		listaCategorias = q.getResultList();
		return listaCategorias;
	}
  
}  

