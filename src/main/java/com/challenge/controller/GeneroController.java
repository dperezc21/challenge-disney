package com.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.dao.genero.GeneroDao;
import com.challenge.disney.models.Genero;

@RestController
public class GeneroController {
	
	@Autowired
	private GeneroDao inyeccion; 
	
	@RequestMapping(value = "generos", method = RequestMethod.GET)
	public List<Genero> getListGeneros() {
		return inyeccion.getGeneros();
	}
	
	@RequestMapping(value = "generos/eliminar/{id}")
	public void eliminarGenero(@PathVariable String id) {
		inyeccion.eliminarGenero(id);
	}
	
	
	@RequestMapping(value = "generos/guardar")
	public void guardarGenero(@RequestBody Genero genero) {
		inyeccion.guardarGenero(genero);
	}
	
	@RequestMapping(value = "generos/buscarPorId/{id}")
	public List<Genero> buscarPorId(@PathVariable String id) {
		return inyeccion.buscarGeneroPorId(id);
	}
	
	@RequestMapping(value = "generos/actualizar", method = RequestMethod.PUT)
	public void actualizarGenero(@RequestBody Genero genero) {
		inyeccion.actualizarGenero(genero);
	}
	

}
