package net.atos.proyecto_atos.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * A DTO for the {@link net.atos.proyecto_atos.entidades.Article} entity
 */
@Getter
@Setter
public class ArticleDTO {
    private Long id;
    private String abstracts;
    private String contents;
    private String titles;
}