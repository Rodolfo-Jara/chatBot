package org.cibertec.edu.pe.Dto;

import lombok.Data;

@Data
public class ReclamoDto {
	private Long Id;
	private String nombre;
	private String reclamo;
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
