package com.torrefactora.persistence.mapper;

import com.torrefactora.domain.Precedence;
import com.torrefactora.persistence.entity.Priority;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PrecedenceMapper {
    @Mappings({
            @Mapping(source = "idPriority", target = "id"),
    })
    Precedence toPrecedence(Priority priority);

    @InheritInverseConfiguration
    @Mapping(target = "tasks", ignore = true)
    Priority toPriority(Precedence precedence);
}
