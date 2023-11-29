package net.atos.proyecto_atos.mappers;

import net.atos.proyecto_atos.dto.CodeDTO;
import net.atos.proyecto_atos.entidades.Code;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
@Component
public interface CodeMapper {
    Code toEntity(CodeDTO codeDTO);

    CodeDTO toDto(Code code);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Code partialUpdate(CodeDTO codeDTO, @MappingTarget Code code);
}