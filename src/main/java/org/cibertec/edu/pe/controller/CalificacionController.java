package org.cibertec.edu.pe.controller;

import java.util.List;

import org.cibertec.edu.pe.model.Calificacion;
import org.cibertec.edu.pe.repository.CalificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Calificaciones")
public class CalificacionController {

	@Autowired
	private CalificacionRepository calificacionRepository;
	
	@PostMapping("/Calificar")
	public ResponseEntity<String> Calificar(@RequestBody Calificacion c) {
        int calificacion = c.getCalficacion();
        if (calificacion >= 1 && calificacion <= 10) {
            calificacionRepository.save(c);
            return ResponseEntity.ok("Calificación guardada exitosamente");
        } else {
           
            return ResponseEntity.badRequest().body("La calificación debe estar en el rango de 1 a 10.");
        }
    }
	@GetMapping("/listar")
    public List<Calificacion> ObtenerTodo() {
        return calificacionRepository.findAll();
    }

}
