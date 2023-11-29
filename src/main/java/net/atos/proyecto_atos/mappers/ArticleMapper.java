package net.atos.proyecto_atos.mappers;

import net.atos.proyecto_atos.dto.ArticleDTO;
import net.atos.proyecto_atos.entidades.Article;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
@Component
public interface ArticleMapper {
    Article toEntity(ArticleDTO articleDTO);

    ArticleDTO toDto(Article article);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Article partialUpdate(ArticleDTO articleDTO, @MappingTarget Article article);
}