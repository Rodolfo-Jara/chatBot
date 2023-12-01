package org.cibertec.edu.pe.service;

import java.util.List;

import org.cibertec.edu.pe.Dto.CalificacionDto;
import org.cibertec.edu.pe.Dto.ResponseDTO;
import org.cibertec.edu.pe.model.Calificacion;

public interface CalificacionService {
	public List<Calificacion> findAll();
	public ResponseDTO createCalificacion(CalificacionDto calificacionDto);
}
