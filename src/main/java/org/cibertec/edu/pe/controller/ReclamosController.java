package org.cibertec.edu.pe.controller;

import java.util.List;

import org.cibertec.edu.pe.Dto.ReclamoDto;
import org.cibertec.edu.pe.repository.ReclamoRepository;
import org.cibertec.edu.pe.service.ReclamosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reclamos")
public class ReclamosController {
	
	private final ReclamosService reclamosService;
	@Autowired
	private ReclamoRepository reclamoRepository;
	
	
	 @Autowired
	    public ReclamosController(ReclamosService reclamosService) {
	        this.reclamosService = reclamosService;
	    }
	 
	 @PostMapping("/guardar")
	    public ResponseEntity<ReclamoDto> guardarReclamo(@RequestBody ReclamoDto reclamoDto) {
		 ReclamoDto savedReclamo = reclamosService.saveReclamo(reclamoDto);
	        return ResponseEntity.ok(savedReclamo);
	    }
	

	 @GetMapping("/listar")
	    public ResponseEntity<List<ReclamoDto>> listarReclamos() {
	        List<ReclamoDto> reclamosDtoList = reclamosService.getAllReclamos();
	       
	if (reclamosDtoList.isEmpty()) {
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.ok(reclamosDtoList);
	        }
	    }


}