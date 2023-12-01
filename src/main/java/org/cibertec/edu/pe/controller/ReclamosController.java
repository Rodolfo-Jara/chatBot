package org.cibertec.edu.pe.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.cibertec.edu.pe.Dto.ReclamosDTO;
import org.cibertec.edu.pe.model.Reclamos;
import org.cibertec.edu.pe.repository.ReclamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reclamos")
public class ReclamosController {
	
	@Autowired
	private ReclamoRepository reclamoRepository;
	
	@PostMapping("/reclamar")
	public void reclamar(@RequestBody Reclamos r) {
		reclamoRepository.save(r);
	}

	
	@GetMapping("/listar")
    public ResponseEntity<ReclamosDTO> ObtenerTodo() {
        List<Reclamos> reclamos = reclamoRepository.findAll();

        if (reclamos.isEmpty()) {
            // Si no hay reclamos, devolver una respuesta HTTP 204 No Content
            return ResponseEntity.noContent().build();
        } else {
            // Si hay reclamos, mapear la lista de entidades a la lista de DTOs y devolver una respuesta HTTP 200 OK
            List<ReclamosDTO> reclamosDTOs = reclamos.stream()
                    .map(reclamo -> new ReclamosDTO(reclamo.getId(), reclamo.getNombre(), reclamo.getReclamo()))
                    .collect(Collectors.toList());

            ReclamosDTO reclamosResponse = new ReclamosDTO(reclamosDTOs);
            return ResponseEntity.ok(reclamosResponse);
        }
    }
	

}