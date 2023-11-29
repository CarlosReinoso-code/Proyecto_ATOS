package net.atos.proyecto_atos.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * A DTO for the {@link net.atos.proyecto_atos.entidades.User} entity
 */
@Getter
@Setter
public class UserDTO {
    private Long id;
    private String name;
    private String nick;
}