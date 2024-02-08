package com.torrefactora.domain.service;

import com.torrefactora.domain.Assignment;
import com.torrefactora.domain.repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentService {
    @Autowired
    private AssignmentRepository assignmentRepository;

    public List<Assignment> findAll(){
        return assignmentRepository.getAll();
    }
    public Optional<Assignment> getAssignment(long id){
        return assignmentRepository.getAssignment(id);
    }
    public Assignment save(Assignment assignment){
        return assignmentRepository.save(assignment);
    }
}
