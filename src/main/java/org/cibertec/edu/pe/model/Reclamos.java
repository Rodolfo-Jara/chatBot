package org.cibertec.edu.pe.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Reclamos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String nombre;
	private String reclamo;
	
	
	public Reclamos() {
		super();
	}


	public Reclamos(Long id, String nombre, String reclamo) {
		super();
		Id = id;
		this.nombre = nombre;
		this.reclamo = reclamo;
	}


	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getReclamo() {
		return reclamo;
	}


	public void setReclamo(String reclamo) {
		this.reclamo = reclamo;
	}


	
	
	
}
