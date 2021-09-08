package com.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.dao.usuario.UsuarioDao;
import com.challenge.disney.models.Usuario;
import com.challenge.disney.utils.EmailService;
import com.challenge.disney.utils.JWTUtil;
import com.sendgrid.Response;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioDao inyeccion;

	
	@Autowired
	private JWTUtil jwt;
	
	@Autowired
	private EmailService service;
	
	
	@RequestMapping(value = "auth/register")
	public void guardarUsuario(@RequestBody Usuario usuario) {
		
		String body ="Señor@, "+usuario.getNombre()+" "+usuario.getApellido()+"\n"+
						"su registro se realizo exitosamente.";
		
		Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
		String hash = argon2.hash(1, 1024, 1, usuario.getPassword());
		usuario.setPassword(hash);
		service.sendSimpleEmail(usuario.getCorreo(), body, "Registro a la plataforma de persoajes y peliculas disney");
		inyeccion.guardarUsuario(usuario);

	}
	
	@RequestMapping(value = "auth/login")
	public String buscar(@RequestBody Usuario usuario) {
		Usuario usuarioLogin = inyeccion.buscarUsuario(usuario);
		if ( usuarioLogin != null) {
			String token = jwt.create(String.valueOf(usuarioLogin.getId()), usuarioLogin.getPassword());
			return token;
		}
		return "";
	}
	
	/*
	@RequestMapping(value = "characters/actualizar", method = RequestMethod.PUT)
	public void actualizarUsuario(@RequestBody Usuario usuario) {
		inyeccion.actualizarUsuario(usuario);
	}
	*/
	
	/*
	@RequestMapping(value = "characters/eliminar/{id}")
	public void eliminarUsuario(@PathVariable String id) {
		inyeccion.eliminarUsuario(id);
	}
	*/
}
