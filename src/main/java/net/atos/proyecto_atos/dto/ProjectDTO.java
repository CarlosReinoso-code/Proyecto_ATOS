package net.atos.proyecto_atos.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * A DTO for the {@link net.atos.proyecto_atos.entidades.Project} entity
 */
@Getter
@Setter
public class ProjectDTO {
    private Long id;
    private String description;
    private String language;
    private Boolean open = false;
    private List<UserDTO> idUser;

    /**
     * A DTO for the {@link net.atos.proyecto_atos.entidades.User} entity
     */
    @Getter
    @Setter
    public static class UserDTO {
        private Long id;
        private String name;
        private String nick;
    }
}