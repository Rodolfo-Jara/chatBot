package org.cibertec.edu.pe.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
@Entity
public class Calificacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	 @Min(1)
	 @Max(10)
	private int calficacion;
	private String reseña;
	public Calificacion() {
		super();
	}
	public Calificacion(Long id, @Min(1) @Max(10) int calficacion, String reseña) {
		super();
		Id = id;
		this.calficacion = calficacion;
		this.reseña = reseña;
	}
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

