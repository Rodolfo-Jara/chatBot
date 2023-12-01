package org.cibertec.edu.pe.Dto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class ReclamosDTO {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ReclamosDTO> reclamos;

    private Long id;
    private String nombre;
    private String reclamo;

    // Constructors, getters, and setters

    public ReclamosDTO(List<ReclamosDTO> reclamos) {
        this.reclamos = reclamos;
    }

    public ReclamosDTO(Long id, String nombre, String reclamo) {
        this.id = id;
        this.nombre = nombre;
        this.reclamo = reclamo;
    }

    public ReclamosDTO() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getReclamo() {
        return reclamo;
    }

    public void setReclamo(String reclamo) {
        this.reclamo = reclamo;
    }

    public List<ReclamosDTO> getReclamos() {
        return reclamos;
    }

    public void setReclamos(List<ReclamosDTO> reclamos) {
        this.reclamos = reclamos;
    }
}
