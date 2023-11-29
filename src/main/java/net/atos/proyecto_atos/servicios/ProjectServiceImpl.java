package net.atos.proyecto_atos.servicios;

import net.atos.proyecto_atos.dto.ProjectDTO;
import net.atos.proyecto_atos.entidades.Project;
import net.atos.proyecto_atos.excepciones.ResourceNotFoundException;
import net.atos.proyecto_atos.mappers.ProjectMapper;
import net.atos.proyecto_atos.mappers.ProjectMapperImpl;
import net.atos.proyecto_atos.repositorios.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private final ProjectMapper projectMapper = new ProjectMapperImpl();

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public ProjectDTO crearProyecto(ProjectDTO projectDTO) {

        Project project = projectMapper.toEntity(projectDTO);
        Project newProject = projectRepository.save(project);
        return projectMapper.toDto(newProject);
    }

    @Override
    public List<ProjectDTO> getTodosProyectos() {

        List<Project> projectList = projectRepository.findAll();
        return projectList.stream().map(projectMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public ProjectDTO getProyecto(long id) {

        Project project = projectRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Proyecto", "ID", id));
        return projectMapper.toDto(project);
    }

    @Override
    public ProjectDTO actualizarProyecto(ProjectDTO projectDTO, long id) {

        Project project = projectRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Proyecto", "ID", id));
        project.setDescription(projectDTO.getDescription());
        project.setLanguage(projectDTO.getLanguage());
        project.setOpen(projectDTO.getOpen());
        return null;
    }

    @Override
    public void eliminarProyecto(long id) {

        Project project = projectRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Proyecto", "ID", id));
        projectRepository.delete(project);
    }
}
