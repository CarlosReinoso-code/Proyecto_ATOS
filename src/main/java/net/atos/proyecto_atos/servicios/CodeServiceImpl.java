package net.atos.proyecto_atos.servicios;

import net.atos.proyecto_atos.dto.CodeDTO;
import net.atos.proyecto_atos.entidades.Code;
import net.atos.proyecto_atos.excepciones.ResourceNotFoundException;
import net.atos.proyecto_atos.mappers.CodeMapper;
import net.atos.proyecto_atos.repositorios.CodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CodeServiceImpl implements CodeService {

    @Autowired
    private CodeMapper codeMapper;

    @Autowired
    private CodeRepository codeRepository;

    @Override
    public CodeDTO crearCodigo(CodeDTO codeDTO) {

        Code code = codeMapper.toEntity(codeDTO);
        Code newCode = codeRepository.save(code);
        return codeMapper.toDto(newCode);
    }

    @Override
    public List<CodeDTO> getTodosCodigos() {

        List<Code> codeList = codeRepository.findAll();
        return codeList.stream().map(codeMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public CodeDTO getCodigo(long id) {

        Code project = codeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Código", "ID", id));
        return codeMapper.toDto(project);
    }

    @Override
    public CodeDTO actualizarCodigo(CodeDTO codeDTO, long id) {

        Code code = codeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Código", "ID", id));
        code.setFiles(codeDTO.getFiles());
        code.setPackages(codeDTO.getPackages());
        return null;
    }

    @Override
    public void eliminarCodigo(long id) {

        Code project = codeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Código", "ID", id));
        codeRepository.delete(project);
    }
}
