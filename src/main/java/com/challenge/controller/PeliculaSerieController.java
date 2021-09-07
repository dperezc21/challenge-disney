package com.challenge.controller;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.dao.peliculasseries.PeliculasSeriesDao;
import com.challenge.disney.models.PeliculaSerie;
import com.challenge.disney.models.Personaje;

@RestController
public class PeliculaSerieController {

	
	@Autowired
	private PeliculasSeriesDao inyeccion;
	
	@RequestMapping(value ="movies", method = RequestMethod.GET)
	public List<PeliculaSerie> getPeliculaSerie(){
		return inyeccion.getPeliculasSeries();
		
	}
	
	
	@RequestMapping(value ="movies/guardar", method = RequestMethod.POST)
	public void agregarPeliculaSerie(@RequestBody PeliculaSerie peliculaSerie){
		GregorianCalendar fecha = new GregorianCalendar();
		peliculaSerie.setFecha(fecha.getTime());
		inyeccion.guardarPeliculaSerie(peliculaSerie);
	}
	
	@RequestMapping(value ="movies/eliminar/{id}", method = RequestMethod.DELETE)
	public void eliminarPeliculaSerie(@PathVariable String id){
		
		inyeccion.eliminarPeliculaSerie(id);
	}
	
	@RequestMapping(value ="movies/actualizar", method = RequestMethod.PUT)
	public void actualizarPeliculaSerie( @RequestBody PeliculaSerie peliculaSerie ){
		PeliculaSerie p = inyeccion.buscarPeliculaSeriePorId(peliculaSerie.getId()).get(0);
		peliculaSerie.setFecha(p.getFecha());
		inyeccion.actualizarPeliculaSerie(peliculaSerie);
	}
	
	@RequestMapping(value ="movies/bucarPorId/{id}", method = RequestMethod.GET)
	public List<PeliculaSerie> buscarPeliculaSeriePorId(@PathVariable String id){
		return inyeccion.buscarPeliculaSeriePorId(id);
	}
	
	@GetMapping("/movies/buscarPorNombre")
	@ResponseBody
	public List<PeliculaSerie> buscarPeliculaSeriePorNombre(@RequestParam String name){
		
		return inyeccion.buscarPeliculaSeriePorNombre(name);
	}
	
	
	@RequestMapping(value = "movies/desc")
	public List<PeliculaSerie> getPeliculaSerieDesc(){
		return inyeccion.getDesc();
	}
	
	@RequestMapping(value = "movies/asc")
	public List<PeliculaSerie> getPeliculaSerieAsc(){
		return inyeccion.getAsc();
	}
	
	
}
