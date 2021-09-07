package com.challenge.controller;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.dao.personaje.PersonajeDao;
import com.challenge.dao.usuario.UsuarioDao;
import com.challenge.disney.models.Personaje;
import com.challenge.disney.models.Usuario;
import com.challenge.disney.utils.JWTUtil;

@RestController
public class PersonajeController {
	
	@Autowired
	private PersonajeDao inyeccion; 
	
	
	@Autowired
	private JWTUtil jwt;
	
	@RequestMapping(value = "characters")
	public List<Personaje> getPersonajes() {
		return inyeccion.listarPersonajes();
	}
	
	@RequestMapping(value = "characters/eliminar/{id}", method = RequestMethod.DELETE)
	public void eliminarPersonaje( @PathVariable String id) {
		inyeccion.eliminarPersonaje(id);
	}
	
	
	@RequestMapping(value = "characters/guardar")
	public void guardarPersonaje(@RequestBody Personaje personaje) {
		
		inyeccion.guardarPersonaje(personaje);
	}
	
	@RequestMapping(value = "characters/buscarPorId/{id}")
	public List<Personaje> buscarPorId(@PathVariable String id) {
		return inyeccion.buscarPersonajePor("id",id);
	}
	
	@RequestMapping(value = "characters/actualizar", method = RequestMethod.PUT)
	public void actualizarPersonaje(@RequestBody Personaje personaje) {
		inyeccion.actualizarPersonaje(personaje);
	}
	
	
	@GetMapping("/characters/searchByName")
	@ResponseBody
	public List<Personaje> buscarPersonajePorNombre(@RequestParam String name){
		return inyeccion.buscarPersonajePor("nombre", name);
	}
	
	
	@GetMapping("/characters/searchByAge")
	@ResponseBody
	public List<Personaje> buscarPersonajePorEdad( @RequestParam String age){
		
		return inyeccion.buscarPersonajePor("edad", age);
		
	}
	
	
	/*
	@RequestMapping(value = "characters/guardar/imagen/{id}")
	public void guardarImagen( @PathVariable String id) {
		Personaje personaje = inyeccion.buscarPersonajePor("id",id).get(0);
	
		if(!imagen.isEmpty()) {
			Path directorioImagenes = Paths.get("src//main//resources//estatic/imagenes");
			String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
			try {
				byte[] bytesImg = imagen.getBytes();
				Path rutaCompleta = Paths.get(rutaAbsoluta+"//"+ imagen.getOriginalFilename());
				Files.write(rutaCompleta, bytesImg);
				personaje.setImagen(imagen.getOriginalFilename());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		//return inyeccion.buscarPersonajePor("id", id);
		inyeccion.actualizarPersonaje(personaje);
	}*/
	
		
	
	
}
