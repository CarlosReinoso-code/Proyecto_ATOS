package net.atos.proyecto_atos.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * A DTO for the {@link net.atos.proyecto_atos.entidades.Code} entity
 */
@Getter
@Setter
public class CodeDTO {
    private Long id;
    private byte[] files;
    private String packages;
}