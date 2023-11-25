package org.cibertec.edu.pe.repository;

import java.util.Optional;

import org.cibertec.edu.pe.model.MensajeUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatBotRepository extends JpaRepository<MensajeUser, Long> {

	Optional<MensajeUser> findById(Long id);

}
