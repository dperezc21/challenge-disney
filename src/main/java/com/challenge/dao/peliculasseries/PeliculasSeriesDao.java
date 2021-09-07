package com.challenge.dao.peliculasseries;

import java.util.List;

import com.challenge.disney.models.PeliculaSerie;
import com.challenge.disney.models.Personaje;

public interface PeliculasSeriesDao {
	List<PeliculaSerie> getPeliculasSeries();
	void eliminarPeliculaSerie(String id);
	void guardarPeliculaSerie(PeliculaSerie peliculaSerie);
	List<PeliculaSerie> buscarPeliculaSeriePorId(String id);
	void actualizarPeliculaSerie(PeliculaSerie peliculaSerie);
	List<PeliculaSerie> buscarPeliculaSeriePorNombre( String valor );
	List<PeliculaSerie> getAsc();
	List<PeliculaSerie> getDesc();
	
}
