package com.challenge.dao.peliculasseries;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.challenge.disney.models.PeliculaSerie;
import com.challenge.disney.models.Personaje;

@Repository
@Transactional
public class PeliculasSeriesDaoImplement implements PeliculasSeriesDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public List<PeliculaSerie> getPeliculasSeries() {
		String query = "FROM PeliculaSerie";
		return entityManager.createQuery(query).getResultList();
	}

	
	@Override
	public void eliminarPeliculaSerie(String id) {
		PeliculaSerie peliculaSerie = entityManager.find(PeliculaSerie.class, id);
		entityManager.remove(peliculaSerie);
		
	}
	
	@Override
	public void guardarPeliculaSerie(PeliculaSerie peliculaSerie) {
		
			
		entityManager.merge(peliculaSerie);
	}


	@Override
	public List<PeliculaSerie> buscarPeliculaSeriePorId(String id) {
		String query ="FROM PeliculaSerie WHERE id= :id";
		List<PeliculaSerie> p =  entityManager.createQuery(query).setParameter("id", id).getResultList(); 
		return p;
	}


	@Override
	public void actualizarPeliculaSerie(PeliculaSerie peliculaSerie) {
		entityManager.merge(peliculaSerie);
		
	}


	@Override
	public List<PeliculaSerie> buscarPeliculaSeriePorNombre(String valor) {
		
		String query = "FROM PeliculaSerie WHERE titulo= :titulo ";
		List<PeliculaSerie> p = entityManager.createQuery(query).setParameter("titulo", valor).getResultList();
		return p;
	}



	
}