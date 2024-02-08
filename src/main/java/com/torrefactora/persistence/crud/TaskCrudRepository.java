package com.torrefactora.persistence.crud;

import com.torrefactora.persistence.entity.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskCrudRepository extends CrudRepository<Task, Long> {
}
