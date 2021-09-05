package com.challenge.disney.models;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="personaje")
public class Personaje {
	
	@Id
	@Column(name = "id")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	@Column(name = "imagen")
	private String imagen;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "edad")
	private String edad;
	
	@Column(name = "peso")
	private double peso;
	
	@Column(name = "historia")
	private String historia;
	
	/*
	@JoinTable(
			name ="rel_pelicula_serie",
			joinColumns = @JoinColumn(name = "id_personaje", nullable = false),
			inverseJoinColumns = @JoinColumn(name = "id_pelicula_serie", nullable = false)
			)
	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private List<PeliculaSerie> peliculasSeriesAsociadas;
	
	
	
	public void agregarPeliculaSerie(PeliculaSerie p) {
		if(this.peliculasSeriesAsociadas == null) {
			this.peliculasSeriesAsociadas = new ArrayList<>();
		}
		this.peliculasSeriesAsociadas.add(p);	
	}
	
	
	public List<PeliculaSerie> getPeliculasSeriesAsociadas() {
		return this.peliculasSeriesAsociadas;
	}*/


	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public String getHistoria() {
		return historia;
	}
	public void setHistoria(String historia) {
		this.historia = historia;
	}
	
	
	
}
