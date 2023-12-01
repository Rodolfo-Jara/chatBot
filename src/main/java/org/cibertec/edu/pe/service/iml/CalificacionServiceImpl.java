package org.cibertec.edu.pe.service.iml;

import java.util.List;

import org.cibertec.edu.pe.Dto.CalificacionDto;
import org.cibertec.edu.pe.Dto.ResponseDTO;
import org.cibertec.edu.pe.model.Calificacion;
import org.cibertec.edu.pe.repository.CalificacionRepository;
import org.cibertec.edu.pe.service.CalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
@Service
public class CalificacionServiceImpl implements CalificacionService {

	@Autowired
	private CalificacionRepository calificacionRepository;
	@Override
	public List<Calificacion> findAll() {
		// TODO Auto-generated method stub
		return (List<Calificacion>) calificacionRepository.findAll();
	}

	@Override
	public ResponseDTO createCalificacion(CalificacionDto calificacionDto) {
		// TODO Auto-generated method stub
		 ResponseDTO response = new ResponseDTO();
	        try {
	            Calificacion calificacion = convertDtoToEntity(calificacionDto);
	            calificacionRepository.save(calificacion);

	            response.setStatusCode(HttpStatus.CREATED.value());
	            response.setMessage("Calificación creada exitosamente");
	            response.setError(false);
	            response.setData(calificacion);

	        } catch (Exception e) {
	            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
	            response.setMessage("Error al crear la calificación");
	            response.setError(true);
	            response.setData(null);
	        }
	        return response;
	}
	 private Calificacion convertDtoToEntity(CalificacionDto calificacionDto) {
	        Calificacion calificacion = new Calificacion();
	        calificacion.setReseña(calificacionDto.getReseña());
	        calificacion.setCalficacion(calificacionDto.getCalficacion());
	        // Asignar otros atributos según sea necesario
	        return calificacion;
	    }
}
