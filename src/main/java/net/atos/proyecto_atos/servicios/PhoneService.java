package net.atos.proyecto_atos.servicios;

import net.atos.proyecto_atos.dto.PhoneDTO;

import java.util.List;

public interface PhoneService {
    PhoneDTO crearTelefono(PhoneDTO phoneDTO);

    List<PhoneDTO> getTodosTelefonos();

    PhoneDTO getTelefono(long id);

    PhoneDTO actualizarTelefono(PhoneDTO phoneDTO, long id);

    void eliminarTelefono(long id);
}
