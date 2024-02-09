package com.torrefactora.persistence.crud;

import com.torrefactora.persistence.entity.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskCrudRepository extends CrudRepository<Task, Long> {
    List<Task> findByOrderByBeginDateDesc();
}
