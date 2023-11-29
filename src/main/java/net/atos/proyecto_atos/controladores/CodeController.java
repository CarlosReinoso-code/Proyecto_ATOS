package net.atos.proyecto_atos.controladores;

import net.atos.proyecto_atos.dto.CodeDTO;
import net.atos.proyecto_atos.servicios.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/codigos")
public class CodeController {

    @Autowired
    private CodeService codeService;

    @PostMapping
    public ResponseEntity<CodeDTO> saveCode(@Valid @RequestBody CodeDTO codeDTO) {
        return new ResponseEntity<>(codeService.crearCodigo(codeDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public List<CodeDTO> listCodes() {
        return codeService.getTodosCodigos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CodeDTO> getCode(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(codeService.getCodigo(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CodeDTO> setCode(@Valid @RequestBody CodeDTO codeDTO, @PathVariable(name = "id") long id) {
        CodeDTO response = codeService.actualizarCodigo(codeDTO, id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCode(@PathVariable(name = "id") long id) {
        codeService.eliminarCodigo(id);
        return new ResponseEntity<>("Código eliminado correctamente", HttpStatus.OK);
    }
}
