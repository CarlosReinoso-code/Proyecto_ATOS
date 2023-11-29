package net.atos.proyecto_atos.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

/**
 * A DTO for the {@link net.atos.proyecto_atos.entidades.Tag} entity
 */
@Getter
@Setter
public class TagDTO {
    private Long id;
    private Instant dates;
    private String labels;
}