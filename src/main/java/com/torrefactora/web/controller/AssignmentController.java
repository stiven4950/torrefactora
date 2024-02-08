package com.torrefactora.web.controller;

import com.torrefactora.domain.Assignment;
import com.torrefactora.domain.service.AssignmentService;
import com.torrefactora.domain.validation.ValidateResponseBody;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/assignments")
public class AssignmentController {
    @Autowired
    private AssignmentService assignmentService;

    @PostMapping()
    public ResponseEntity<?> save(@Valid @RequestBody Assignment assignment, BindingResult result){
        if (result.hasErrors()) return ValidateResponseBody.throwErrors(result);

        return new ResponseEntity<>(assignmentService.save(assignment), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @Valid @RequestBody Assignment assignment, BindingResult result){
        if (result.hasErrors()) return ValidateResponseBody.throwErrors(result);

        assignment.setId(id);
        return new ResponseEntity<>(assignmentService.save(assignment), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Assignment> getAssignment(@PathVariable("id") int id){
        return assignmentService.getAssignment(id)
                .map(assignment -> new ResponseEntity<>(assignment, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping()
    public ResponseEntity<List<Assignment>> getAll(){
        return new ResponseEntity<>(assignmentService.findAll(), HttpStatus.OK) ;
    }
}
