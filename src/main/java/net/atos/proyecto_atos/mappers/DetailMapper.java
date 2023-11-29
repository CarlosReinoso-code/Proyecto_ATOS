package net.atos.proyecto_atos.mappers;

import net.atos.proyecto_atos.dto.DetailDTO;
import net.atos.proyecto_atos.entidades.Detail;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
@Component
public interface DetailMapper {
    Detail toEntity(DetailDTO detailDTO);

    DetailDTO toDto(Detail detail);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Detail partialUpdate(DetailDTO detailDTO, @MappingTarget Detail detail);
}