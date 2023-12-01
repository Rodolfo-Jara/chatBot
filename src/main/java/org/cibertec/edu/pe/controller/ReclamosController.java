package org.cibertec.edu.pe.controller;

import java.util.List;

import org.cibertec.edu.pe.Dto.ReclamoDto;
import org.cibertec.edu.pe.Dto.ResponseDTO;
import org.cibertec.edu.pe.model.Reclamos;
import org.cibertec.edu.pe.repository.ReclamoRepository;
import org.cibertec.edu.pe.service.ReclamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reclamos")
public class ReclamosController {
	@Autowired
	private ReclamoService reclamosService;
	
	
	
	@PostMapping("/create")
	public ResponseDTO createUser(@RequestBody ReclamoDto reclamo) {
		return reclamosService.createReclamo(reclamo);
	}
	

	 @GetMapping("/findAll")
		public List<Reclamos> findAll(){
			return reclamosService.findAll();
		}

	 @PutMapping("/update/{id}")
	    public ResponseEntity<ResponseDTO> updateReclamo(@PathVariable Long id, @RequestBody ReclamoDto reclamoDto) {
	        ResponseDTO response = reclamosService.updateReclamo(id, reclamoDto);
	        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
	    }

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<ResponseDTO> deleteReclamo(@PathVariable Long id) {
	        ResponseDTO response = reclamosService.deleteReclamo(id);
	        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
	    }
}