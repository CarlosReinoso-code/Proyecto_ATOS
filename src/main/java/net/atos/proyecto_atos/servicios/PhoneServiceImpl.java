package net.atos.proyecto_atos.servicios;

import net.atos.proyecto_atos.dto.PhoneDTO;
import net.atos.proyecto_atos.entidades.Phone;
import net.atos.proyecto_atos.excepciones.ResourceNotFoundException;
import net.atos.proyecto_atos.mappers.PhoneMapper;
import net.atos.proyecto_atos.repositorios.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhoneMapper phoneMapper;

    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    public PhoneDTO crearTelefono(PhoneDTO projectDTO) {

        Phone phone = phoneMapper.toEntity(projectDTO);
        Phone newProject = phoneRepository.save(phone);
        return phoneMapper.toDto(newProject);
    }

    @Override
    public List<PhoneDTO> getTodosTelefonos() {

        List<Phone> phoneList = phoneRepository.findAll();
        return phoneList.stream().map(phoneMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public PhoneDTO getTelefono(long id) {

        Phone project = phoneRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Teléfono", "ID", id));
        return phoneMapper.toDto(project);
    }

    @Override
    public PhoneDTO actualizarTelefono(PhoneDTO projectDTO, long id) {

        Phone phone = phoneRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Teléfono", "ID", id));
        phone.setTypes(projectDTO.getTypes());
        phone.setPhoneValues(projectDTO.getPhoneValues());
        return null;
    }

    @Override
    public void eliminarTelefono(long id) {

        Phone project = phoneRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Teléfono", "ID", id));
        phoneRepository.delete(project);
    }
}
