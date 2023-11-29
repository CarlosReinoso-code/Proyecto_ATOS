package net.atos.proyecto_atos.mappers;

import net.atos.proyecto_atos.dto.BlogDTO;
import net.atos.proyecto_atos.entidades.Blog;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
@Component
public interface BlogMapper {
    Blog toEntity(BlogDTO blogDTO);

    BlogDTO toDto(Blog blog);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Blog partialUpdate(BlogDTO blogDTO, @MappingTarget Blog blog);
}