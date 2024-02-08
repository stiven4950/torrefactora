package com.torrefactora.persistence.mapper;

import com.torrefactora.domain.State;
import com.torrefactora.persistence.entity.Status;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface StateMapper {
    @Mappings({
            @Mapping(source = "idStatus", target = "id"),
    })
    State toState(Status status);

    @InheritInverseConfiguration
    @Mapping(target = "tasks", ignore = true)
    Status toStatus(State state);
}
