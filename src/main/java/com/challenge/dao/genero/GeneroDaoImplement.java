package com.challenge.dao.genero;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.challenge.disney.models.Genero;

@Repository
@Transactional
public class GeneroDaoImplement implements GeneroDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public List<Genero> getGeneros() {
		String query = "FROM Genero";
		return entityManager.createQuery(query).getResultList();
	}

	
	@Override
	public void eliminarGenero(String id) {
		Genero genero = entityManager.find(Genero.class, id);
		entityManager.remove(genero);
		
	}
	
	@Override
	public void guardarGenero(Genero genero) {
		entityManager.merge(genero);
	}


	@Override
	public List<Genero> buscarGeneroPorId(String id) {
		String query ="FROM Genero WHERE id= :id";
		List<Genero> g =  entityManager.createQuery(query).setParameter("id", id).getResultList(); 
		return g;
	}


	@Override
	public void actualizarGenero(Genero genero) {
		entityManager.merge(genero);
		
	}

}
