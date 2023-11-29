package net.atos.proyecto_atos.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

/**
 * A DTO for the {@link net.atos.proyecto_atos.entidades.Blog} entity
 */
@Getter
@Setter
public class BlogDTO {
    private Long id;
    private Instant date;
    private String title;
}