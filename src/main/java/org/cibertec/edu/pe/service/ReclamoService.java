package org.cibertec.edu.pe.service;

import java.util.List;

import org.cibertec.edu.pe.Dto.ReclamoDto;
import org.cibertec.edu.pe.Dto.ResponseDTO;
import org.cibertec.edu.pe.model.Reclamos;

public interface ReclamoService {
	public List<Reclamos> findAll();
	public ResponseDTO createReclamo(ReclamoDto reclamo);
	public ResponseDTO updateReclamo(Long id, ReclamoDto reclamoDto);
	public ResponseDTO deleteReclamo(Long id);
}
