package org.cibertec.edu.pe.Dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class CalificacionDto {
	
	private Long Id;
	 @Min(1)
	 @Max(10)
	private int calficacion;
	private String reseña;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public int getCalficacion() {
		return calficacion;
	}
	public void setCalficacion(int calficacion) {
		this.calficacion = calficacion;
	}
	public String getReseña() {
		return reseña;
	}
	public void setReseña(String reseña) {
		this.reseña = reseña;
	}
	
	
}
