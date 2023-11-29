package net.atos.proyecto_atos.controladores;

import net.atos.proyecto_atos.dto.TagDTO;
import net.atos.proyecto_atos.servicios.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagController {

    @Autowired
    private TagService tagService;

    @PostMapping
    public ResponseEntity<TagDTO> saveTag(@Valid @RequestBody TagDTO tagDTO) {
        return new ResponseEntity<>(tagService.crearTag(tagDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public List<TagDTO> listTags() {
        return tagService.getTodosTags();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TagDTO> getTag(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(tagService.getTag(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TagDTO> setTag(@Valid @RequestBody TagDTO tagDTO, @PathVariable(name = "id") long id) {
        TagDTO response = tagService.actualizarTag(tagDTO, id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTag(@PathVariable(name = "id") long id) {
        tagService.eliminarTag(id);
        return new ResponseEntity<>("Tag eliminado correctamente", HttpStatus.OK);
    }
}
