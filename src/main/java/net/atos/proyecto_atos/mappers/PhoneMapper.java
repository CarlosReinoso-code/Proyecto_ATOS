package net.atos.proyecto_atos.mappers;

import net.atos.proyecto_atos.dto.PhoneDTO;
import net.atos.proyecto_atos.entidades.Phone;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
@Component
public interface PhoneMapper {
    Phone toEntity(PhoneDTO phoneDTO);

    PhoneDTO toDto(Phone phone);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Phone partialUpdate(PhoneDTO phoneDTO, @MappingTarget Phone phone);
}