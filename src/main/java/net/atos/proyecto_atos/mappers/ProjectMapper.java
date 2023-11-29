package net.atos.proyecto_atos.mappers;

import net.atos.proyecto_atos.dto.ProjectDTO;
import net.atos.proyecto_atos.entidades.Project;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
@Component
public interface ProjectMapper {
    Project toEntity(ProjectDTO projectDTO);

    ProjectDTO toDto(Project project);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Project partialUpdate(ProjectDTO projectDTO, @MappingTarget Project project);
}