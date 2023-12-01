package org.cibertec.edu.pe.service.iml;

import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.Dto.ReclamoDto;
import org.cibertec.edu.pe.Dto.ResponseDTO;
import org.cibertec.edu.pe.model.Reclamos;
import org.cibertec.edu.pe.repository.ReclamoRepository;
import org.cibertec.edu.pe.service.ReclamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ReclamoServiceImpl implements ReclamoService {

	@Autowired
	private ReclamoRepository reclamoRepository;
	
	@Override
	public List<Reclamos> findAll() {
		// TODO Auto-generated method stub
		return (List<Reclamos>) reclamoRepository.findAll();
	}

	@Override
	public ResponseDTO createReclamo(ReclamoDto reclamo) {
		// TODO Auto-generated method stub
		ResponseDTO response = new ResponseDTO();
        try {
            Reclamos reclamo1 = convertDtoToEntity(reclamo);
            reclamoRepository.save(reclamo1);

            response.setStatusCode(HttpStatus.CREATED.value());
            response.setMessage("Reclamo creado exitosamente");
            response.setError(false);
            response.setData(reclamo1);

        } catch (Exception e) {
            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setMessage("Error al crear el reclamo");
            response.setError(true);
            response.setData(null);
        }
        return response;
	}

	@Override
    public ResponseDTO updateReclamo(Long id, ReclamoDto reclamoDto) {
        ResponseDTO response = new ResponseDTO();
        try {
            Optional<Reclamos> optionalReclamo = reclamoRepository.findById(id);

            if (optionalReclamo.isPresent()) {
                Reclamos reclamo = optionalReclamo.get();
                // Actualizar los campos del reclamo con los valores proporcionados en el DTO
                reclamo.setNombre(reclamoDto.getNombre());
                reclamo.setReclamo(reclamoDto.getReclamo());

                reclamoRepository.save(reclamo);

                response.setStatusCode(HttpStatus.OK.value());
                response.setMessage("Reclamo actualizado exitosamente");
                response.setError(false);
                response.setData(reclamo);
            } else {
                response.setStatusCode(HttpStatus.NOT_FOUND.value());
                response.setMessage("Reclamo no encontrado");
                response.setError(true);
                response.setData(null);
            }

        } catch (Exception e) {
            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setMessage("Error al actualizar el reclamo");
            response.setError(true);
            response.setData(null);
        }
        return response;
    }

	@Override
	public ResponseDTO deleteReclamo(Long id) {
		// TODO Auto-generated method stub
		ResponseDTO response = new ResponseDTO();
        try {
            Optional<Reclamos> optionalReclamo = reclamoRepository.findById(id);

            if (optionalReclamo.isPresent()) {
                Reclamos reclamo = optionalReclamo.get();
                reclamoRepository.delete(reclamo);

                response.setStatusCode(HttpStatus.OK.value());
                response.setMessage("Reclamo eliminado exitosamente");
                response.setError(false);
                response.setData(null);
            } else {
                response.setStatusCode(HttpStatus.NOT_FOUND.value());
                response.setMessage("Reclamo no encontrado");
                response.setError(true);
                response.setData(null);
            }

        } catch (Exception e) {
            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setMessage("Error al eliminar el reclamo");
            response.setError(true);
            response.setData(null);
        }
        return response;
	}

	private Reclamos convertDtoToEntity(ReclamoDto reclamoDto) {
        Reclamos reclamo = new Reclamos();
        reclamo.setNombre(reclamoDto.getNombre());
        reclamo.setReclamo(reclamoDto.getReclamo());
        return reclamo;
    }

}
