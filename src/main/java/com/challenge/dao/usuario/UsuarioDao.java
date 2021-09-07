package com.challenge.dao.usuario;

import java.util.List;

import com.challenge.disney.models.Personaje;
import com.challenge.disney.models.Usuario;

public interface UsuarioDao {
	
	//void eliminarUsuario(String id);
	void guardarUsuario(Usuario usuario);
	Usuario buscarUsuario(Usuario usuario);
	//void actualizarUsuario(Usuario personaje);
	Usuario buscarUsuarioPorId(String id);
	
	
}
