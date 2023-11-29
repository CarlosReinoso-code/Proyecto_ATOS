package net.atos.proyecto_atos.servicios;

import net.atos.proyecto_atos.dto.ProjectDTO;

import java.util.List;

public interface ProjectService {
    ProjectDTO crearProyecto(ProjectDTO projectDTO);

    List<ProjectDTO> getTodosProyectos();

    ProjectDTO getProyecto(long id);

    ProjectDTO actualizarProyecto(ProjectDTO projectDTO, long id);

    void eliminarProyecto(long id);
}
