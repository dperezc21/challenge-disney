package com.challenge.dao.genero;

import java.util.List;

import com.challenge.disney.models.Genero;

public interface GeneroDao {
	List<Genero> getGeneros();
	void eliminarGenero(String id);
	void guardarGenero(Genero genero);
	void actualizarGenero(Genero genero);
	List<Genero> buscarGeneroPorId( String id );
	
}
