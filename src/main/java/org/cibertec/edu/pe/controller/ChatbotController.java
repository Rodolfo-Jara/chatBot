package org.cibertec.edu.pe.controller;

import java.util.List;

import org.cibertec.edu.pe.model.MensajeUser;
import org.cibertec.edu.pe.repository.ChatBotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chatbot")
public class ChatbotController {

	@Autowired
	private ChatBotRepository chatBotRepository;
	
	@PostMapping("/comentarios")
	public MensajeUser agregarTexto(@RequestBody String texto) {
		MensajeUser mensajeUser = new MensajeUser();
		mensajeUser.setTexto(texto);
		return chatBotRepository.save(mensajeUser);
	}
	@PostMapping("/calificar")
	public void Anadir(@RequestBody MensajeUser c) {
		chatBotRepository.save(c);
	}
	@GetMapping("/listar")
    public List<MensajeUser> ObtenerTodo() {
        return chatBotRepository.findAll();
    }
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<MensajeUser> ObtenerPorId(@PathVariable Long id){
	    return ResponseEntity.of(chatBotRepository.findById(id));
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<MensajeUser> Buscar(@PathVariable("id") Long id) {
		return ResponseEntity.of(chatBotRepository.findById(id));
	}
}
