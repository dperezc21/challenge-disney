package com.challenge.dao.personaje;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.challenge.disney.models.Personaje;

@Repository
@Transactional
public class PersonajeDaoImplement implements PersonajeDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public List<Personaje> listarPersonajes() {
		String query = "FROM Personaje";
		return entityManager.createQuery(query).getResultList();
	}

	
	@Override
	public void eliminarPersonaje(String id) {
		Personaje personaje = entityManager.find(Personaje.class, id);
		entityManager.remove(personaje);
		
	}
	
	@Override
	public void guardarPersonaje(Personaje personaje) {
		entityManager.merge(personaje);
	}


	/*
	@Override
	public List<Personaje> buscarPorId(String id) {
		String query ="FROM Personaje WHERE id= :id";
		List<Personaje> p =  entityManager.createQuery(query).setParameter("id", id).getResultList(); 
		return p;
	}*/


	@Override
	public void actualizarPersonaje(Personaje personaje) {
		entityManager.merge(personaje);
		
	}


	@Override
	public List<Personaje> buscarPersonajePor(String campo, String valor) {
		
		String query = String.format("FROM Personaje WHERE %s= :nombre ", campo);
		List<Personaje> p = entityManager.createQuery(query).setParameter("nombre", valor).getResultList();
		return p;
	}

		
}
