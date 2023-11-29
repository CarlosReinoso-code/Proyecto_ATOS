package net.atos.proyecto_atos.controladores;


import net.atos.proyecto_atos.dto.UserDTO;
import net.atos.proyecto_atos.servicios.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> saveUser(@Valid @RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userService.crearUsuario(userDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public List<UserDTO> listUsers() {
        return userService.getTodosUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(userService.getUsuario(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> setUser(@Valid @RequestBody UserDTO userDTO, @PathVariable(name = "id") long id) {
        UserDTO response = userService.actualizarUsuario(userDTO, id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(name = "id") long id) {
        userService.eliminarUsuario(id);
        return new ResponseEntity<>("Usuario eliminado correctamente", HttpStatus.OK);
    }
}
