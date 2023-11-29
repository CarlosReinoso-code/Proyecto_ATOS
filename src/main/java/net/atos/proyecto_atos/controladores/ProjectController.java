package net.atos.proyecto_atos.controladores;

import net.atos.proyecto_atos.dto.ProjectDTO;
import net.atos.proyecto_atos.servicios.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/proyectos")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping
    public ResponseEntity<ProjectDTO> saveProject(@Valid @RequestBody ProjectDTO projectDTO) {
        return new ResponseEntity<>(projectService.crearProyecto(projectDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public List<ProjectDTO> listProjects() {
        return projectService.getTodosProyectos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDTO> getProject(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(projectService.getProyecto(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectDTO> setProject(@Valid @RequestBody ProjectDTO projectDTO, @PathVariable(name = "id") long id) {
        ProjectDTO response = projectService.actualizarProyecto(projectDTO, id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable(name = "id") long id) {
        projectService.eliminarProyecto(id);
        return new ResponseEntity<>("Proyecto eliminado correctamente", HttpStatus.OK);
    }
}
