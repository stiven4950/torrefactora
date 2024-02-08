package com.torrefactora.persistence.mapper;

import com.torrefactora.domain.Assignment;
import com.torrefactora.persistence.entity.Task;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PrecedenceMapper.class, StateMapper.class})
public interface AssignmentMapper {
    @Mappings({
            @Mapping(source = "idTask", target = "id"),
            @Mapping(source = "priority.name", target="priority"),
            @Mapping(source = "status.name", target="status"),
    })
    Assignment toAssignment(Task task);
    List<Assignment> toAssignments(List<Task> tasks);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target="priority", ignore = true),
            @Mapping(target="status", ignore = true),
    })
    Task toTask(Assignment assignment);
}
