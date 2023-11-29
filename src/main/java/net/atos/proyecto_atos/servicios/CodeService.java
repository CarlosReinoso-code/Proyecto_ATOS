package net.atos.proyecto_atos.servicios;

import net.atos.proyecto_atos.dto.CodeDTO;

import java.util.List;

public interface CodeService {
    CodeDTO crearCodigo(CodeDTO codeDTO);

    List<CodeDTO> getTodosCodigos();

    CodeDTO getCodigo(long id);

    CodeDTO actualizarCodigo(CodeDTO codeDTO, long id);

    void eliminarCodigo(long id);
}
