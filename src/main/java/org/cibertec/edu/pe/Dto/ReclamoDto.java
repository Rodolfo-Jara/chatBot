package org.cibertec.edu.pe.Dto;

public class ReclamoDto {
	private Long Id;
	private String nombre;
	private String reclamo;
	public ReclamoDto(Long id, String nombre, String reclamo) {
		super();
		Id = id;
		this.nombre = nombre;
		this.reclamo = reclamo;
	}
	public ReclamoDto() {
		super();
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