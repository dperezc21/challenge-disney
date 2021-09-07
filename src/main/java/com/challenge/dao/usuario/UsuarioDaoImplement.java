package com.challenge.dao.usuario;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.challenge.disney.models.Personaje;
import com.challenge.disney.models.Usuario;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import de.mkammerer.argon2.Argon2Factory.Argon2Types;

@Repository
@Transactional
public class UsuarioDaoImplement implements UsuarioDao {

	@PersistenceContext
	private EntityManager entityManager;

/*	
	@Override
	public void eliminarUsuario(String id) {
		Usuario usuario = entityManager.find(Usuario.class, id);
		entityManager.remove(usuario);
		
	}
	*/
	@Override
	public void guardarUsuario(Usuario usuario) {
		entityManager.merge(usuario);
	}
	
	
	@Override
	public Usuario buscarUsuarioPorId(String id) {
		String query = "FROM Usuario where id= :id";
		return (Usuario)entityManager.createQuery(query).setParameter("id", id).getResultList();
	}


	@Override
	public Usuario buscarUsuario(Usuario usuario) {
		String query ="FROM Usuario WHERE correo= :correo";
		List<Usuario> u =  entityManager.createQuery(query)
							.setParameter("correo", usuario.getCorreo())
							.getResultList(); 
		
		Argon2 argon = Argon2Factory.create(Argon2Types.ARGON2id);
		
		if (u.isEmpty()) {
			return null;
		}
		
		
		if(argon.verify(u.get(0).getPassword(), usuario.getPassword())) {
			return u.get(0);
		}
		
		
		return null;
	}

/*
	@Override
	public void actualizarUsuario(Usuario usuario) {
		entityManager.merge(usuario);
		
	}
*/
	
	
	
}