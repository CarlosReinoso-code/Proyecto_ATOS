package net.atos.proyecto_atos.servicios;

import net.atos.proyecto_atos.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO crearUsuario(UserDTO userDTO);

    List<UserDTO> getTodosUsuarios();

    UserDTO getUsuario(long id);

    UserDTO actualizarUsuario(UserDTO userDTO, long id);

    void eliminarUsuario(long id);
}
