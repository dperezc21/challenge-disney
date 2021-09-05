package com.challenge.disney.models;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "pelicula_serie")
public class PeliculaSerie {
	
	@Id
	@Column(name = "id")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "fecha_creacion")
	private Date fecha_creacion;
	
	@Column(name = "calificacion")
	private String calificacion;
	
	@Column(name = "imagen")
	private String imagen;
	
	/*
	@ManyToMany(mappedBy = "peliculasSeriesAsociadas")
	private List<Personaje> personajesAsociados;
	
	public PeliculaSerie() {
		this.personajesAsociados = new ArrayList<>();
	}
	

	public List<Personaje> getPersonajesAsociados() {
		return personajesAsociados;
	}

	public void agregarPersonajesAsociados(Personaje personajesAsociados) {
		
		this.personajesAsociados.add(personajesAsociados);
	}*/

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFecha() {
		return fecha_creacion;
	}

	public void setFecha(Date fecha) {
		this.fecha_creacion = fecha;
	}

	public String getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
	
	

}
