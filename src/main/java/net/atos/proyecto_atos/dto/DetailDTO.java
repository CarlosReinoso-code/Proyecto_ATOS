package net.atos.proyecto_atos.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

/**
 * A DTO for the {@link net.atos.proyecto_atos.entidades.Detail} entity
 */
@Getter
@Setter
public class DetailDTO {
    private Long id;
    private Long budgets;
    private String contents;
    private Instant dates;
    private String types;
}