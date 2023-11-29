package net.atos.proyecto_atos.controladores;

import net.atos.proyecto_atos.dto.DetailDTO;
import net.atos.proyecto_atos.servicios.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/detalles")
public class DetailController {

    @Autowired
    private DetailService detailService;

    @PostMapping
    public ResponseEntity<DetailDTO> saveProject(@Valid @RequestBody DetailDTO detailDTO) {
        return new ResponseEntity<>(detailService.crearDetalle(detailDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public List<DetailDTO> listProjects() {
        return detailService.getTodosDetalles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailDTO> getProject(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(detailService.getDetalle(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetailDTO> setProject(@Valid @RequestBody DetailDTO detailDTO, @PathVariable(name = "id") long id) {
        DetailDTO response = detailService.actualizarDetalle(detailDTO, id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable(name = "id") long id) {
        detailService.eliminarDetalle(id);
        return new ResponseEntity<>("Detalle eliminado correctamente", HttpStatus.OK);
    }
}
