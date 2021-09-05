package com.challenge.dao.personaje;

import java.util.List;

import com.challenge.disney.models.Personaje;

public interface PersonajeDao {
	List<Personaje> listarPersonajes();
	void eliminarPersonaje(String id);
	void guardarPersonaje(Personaje Personaje);
	//List<Personaje> buscarPorId(String id);
	void actualizarPersonaje(Personaje personaje);
	List<Personaje> buscarPersonajePor(String campo, String valor );
	
	
}
