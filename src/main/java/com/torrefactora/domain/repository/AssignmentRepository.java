package com.torrefactora.domain.repository;

import com.torrefactora.domain.Assignment;

import java.util.List;
import java.util.Optional;

public interface AssignmentRepository {
    List<Assignment> getAll();
    Optional<Assignment> getAssignment(long id);
    Assignment save(Assignment assignment);
}
