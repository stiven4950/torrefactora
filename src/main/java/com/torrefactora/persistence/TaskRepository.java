package com.torrefactora.persistence;

import com.torrefactora.domain.Assignment;
import com.torrefactora.domain.repository.AssignmentRepository;
import com.torrefactora.persistence.crud.TaskCrudRepository;
import com.torrefactora.persistence.entity.Priority;
import com.torrefactora.persistence.entity.Status;
import com.torrefactora.persistence.entity.Task;
import com.torrefactora.persistence.mapper.AssignmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Repository
public class TaskRepository implements AssignmentRepository {
    @Autowired
    private TaskCrudRepository taskCrudRespository;

    @Autowired
    private AssignmentMapper mapper;

    @Override
    public List<Assignment> getAll() {
        List<Task> tasks = (List<Task>) taskCrudRespository.findAll();
        tasks.forEach(task -> System.out.println(task.getStatus().getName()));
        return mapper.toAssignments(tasks);
    }

    @Override
    public Optional<Assignment> getAssignment(long id) {
        return taskCrudRespository.findById(id).map(task -> mapper.toAssignment(task));
    }

    @Override
    public Assignment save(Assignment assignment) {
        Task task = mapper.toTask(assignment);

        Priority priority = new Priority();
        priority.setIdPriority(
                assignment.getPriority().equals("URGENTE")?1L:
                        assignment.getPriority().equals("NORMAL")? 2L: 3L
        );


        Status status = new Status();
        status.setIdStatus(
                assignment.getStatus().equals("INICIADA")?1L:
                        assignment.getStatus().equals("EN PROCESO")? 2L: 3L
        );

        task.setPriority(priority);
        task.setStatus(status);
        return mapper.toAssignment(taskCrudRespository.save(task));
    }
}
