package net.atos.proyecto_atos.controladores;

import net.atos.proyecto_atos.dto.PhoneDTO;
import net.atos.proyecto_atos.servicios.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/telefonos")
public class PhoneController {

    @Autowired
    private PhoneService phoneService;

    @PostMapping
    public ResponseEntity<PhoneDTO> savePhone(@Valid @RequestBody PhoneDTO phoneDTO) {
        return new ResponseEntity<>(phoneService.crearTelefono(phoneDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public List<PhoneDTO> listPhone() {
        return phoneService.getTodosTelefonos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhoneDTO> getPhone(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(phoneService.getTelefono(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PhoneDTO> setPhone(@Valid @RequestBody PhoneDTO phoneDTO, @PathVariable(name = "id") long id) {
        PhoneDTO response = phoneService.actualizarTelefono(phoneDTO, id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePhone(@PathVariable(name = "id") long id) {
        phoneService.eliminarTelefono(id);
        return new ResponseEntity<>("Teléfono eliminado correctamente", HttpStatus.OK);
    }
}
