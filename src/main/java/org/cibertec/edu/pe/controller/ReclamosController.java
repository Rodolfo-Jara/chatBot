package org.cibertec.edu.pe.controller;

import java.util.List;
import org.cibertec.edu.pe.model.Reclamos;
import org.cibertec.edu.pe.repository.ReclamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Reclamos> ObtenerTodo() {
        return reclamoRepository.findAll();
    }
}
