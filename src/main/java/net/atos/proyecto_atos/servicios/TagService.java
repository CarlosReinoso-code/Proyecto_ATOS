package net.atos.proyecto_atos.servicios;

import net.atos.proyecto_atos.dto.TagDTO;

import java.util.List;

public interface TagService {
    TagDTO crearTag(TagDTO tagDTO);

    List<TagDTO> getTodosTags();

    TagDTO getTag(long id);

    TagDTO actualizarTag(TagDTO tagDTO, long id);

    void eliminarTag(long id);
}
