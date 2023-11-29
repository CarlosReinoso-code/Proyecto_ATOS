package net.atos.proyecto_atos.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * A DTO for the {@link net.atos.proyecto_atos.entidades.Phone} entity
 */
@Getter
@Setter
public class PhoneDTO {
    private Long id;
    private String types;
    private String phoneValues;
}