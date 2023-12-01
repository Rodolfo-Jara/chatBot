// ReclamosService.java
package org.cibertec.edu.pe.service;


import org.cibertec.edu.pe.Dto.ReclamoDto;
import org.cibertec.edu.pe.model.Reclamos;
import org.cibertec.edu.pe.repository.ReclamoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReclamosService {

    private final ReclamoRepository reclamosRepository;

    @Autowired
    public ReclamosService(ReclamoRepository reclamosRepository) {
        this.reclamosRepository = reclamosRepository;
    }

    public List<ReclamoDto> getAllReclamos() {
        List<Reclamos> reclamos = reclamosRepository.findAll();

        return reclamos.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private ReclamoDto convertToDto(Reclamos reclamo) {
    	ReclamoDto reclamoDto = new ReclamoDto();
        BeanUtils.copyProperties(reclamo, reclamoDto);
        return reclamoDto;
    }
    public ReclamoDto saveReclamo(ReclamoDto reclamoDto) {
        Reclamos reclamo = convertToEntity(reclamoDto);
        Reclamos savedReclamo = reclamosRepository.save(reclamo);
        return convertToDto(savedReclamo);
    }
    private Reclamos convertToEntity(ReclamoDto reclamoDto) {
        Reclamos reclamo = new Reclamos();
        BeanUtils.copyProperties(reclamoDto, reclamo);
        return reclamo;
    }
}
