package net.atos.proyecto_atos.servicios;

import net.atos.proyecto_atos.dto.UserDTO;
import net.atos.proyecto_atos.entidades.User;
import net.atos.proyecto_atos.excepciones.ResourceNotFoundException;
import net.atos.proyecto_atos.mappers.UserMapper;
import net.atos.proyecto_atos.mappers.UserMapperImpl;
import net.atos.proyecto_atos.repositorios.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserMapper userMapper = new UserMapperImpl();

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO crearUsuario(UserDTO userDTO) {

        User user = userMapper.toEntity(userDTO);
        User newUser = userRepository.save(user);
        return userMapper.toDto(newUser);
    }

    @Override
    public List<UserDTO> getTodosUsuarios() {

        List<User> userList = userRepository.findAll();
        return userList.stream().map(userMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public UserDTO getUsuario(long id) {

        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario", "ID", id));
        return userMapper.toDto(user);
    }

    @Override
    public UserDTO actualizarUsuario(UserDTO userDTO, long id) {

        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario", "ID", id));
        user.setName(userDTO.getName());
        user.setNick(userDTO.getNick());
        return null;
    }

    @Override
    public void eliminarUsuario(long id) {

        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario", "ID", id));
        userRepository.delete(user);
    }
}
