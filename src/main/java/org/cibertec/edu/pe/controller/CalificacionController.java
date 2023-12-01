package org.cibertec.edu.pe.controller;

import java.util.List;

import org.cibertec.edu.pe.Dto.CalificacionDto;
import org.cibertec.edu.pe.Dto.ResponseDTO;
import org.cibertec.edu.pe.model.Calificacion;
import org.cibertec.edu.pe.service.CalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Calificaciones")
public class CalificacionController {

	@Autowired
	private CalificacionService calificacionService;
	@PostMapping("/create")
	public ResponseDTO createCalificacion(@RequestBody CalificacionDto calificacionDto) {
		return calificacionService.createCalificacion(calificacionDto);
	}
	

	 @GetMapping("/findAll")
		public List<Calificacion> findAll(){
			return calificacionService.findAll();
		}
}
