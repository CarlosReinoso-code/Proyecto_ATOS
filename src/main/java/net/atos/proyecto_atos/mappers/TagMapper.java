package net.atos.proyecto_atos.mappers;

import net.atos.proyecto_atos.dto.TagDTO;
import net.atos.proyecto_atos.entidades.Tag;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
@Component
public interface TagMapper {
    Tag toEntity(TagDTO tagDTO);

    TagDTO toDto(Tag tag);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Tag partialUpdate(TagDTO tagDTO, @MappingTarget Tag tag);
}