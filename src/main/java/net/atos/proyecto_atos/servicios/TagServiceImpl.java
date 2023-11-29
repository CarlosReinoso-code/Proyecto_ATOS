package net.atos.proyecto_atos.servicios;

import net.atos.proyecto_atos.dto.TagDTO;
import net.atos.proyecto_atos.entidades.Tag;
import net.atos.proyecto_atos.excepciones.ResourceNotFoundException;
import net.atos.proyecto_atos.mappers.TagMapper;
import net.atos.proyecto_atos.repositorios.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private TagRepository tagRepository;

    @Override
    public TagDTO crearTag(TagDTO tagDTO) {

        Tag tag = tagMapper.toEntity(tagDTO);
        Tag newTag = tagRepository.save(tag);
        return tagMapper.toDto(newTag);
    }

    @Override
    public List<TagDTO> getTodosTags() {

        List<Tag> tagList = tagRepository.findAll();
        return tagList.stream().map(tagMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public TagDTO getTag(long id) {

        Tag tag = tagRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Proyecto", "ID", id));
        return tagMapper.toDto(tag);
    }

    @Override
    public TagDTO actualizarTag(TagDTO tagDTO, long id) {

        Tag tag = tagRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Proyecto", "ID", id));
        tag.setDates(tagDTO.getDates());
        tag.setLabels(tagDTO.getLabels());
        return null;
    }

    @Override
    public void eliminarTag(long id) {

        Tag tag = tagRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Proyecto", "ID", id));
        tagRepository.delete(tag);
    }
}
