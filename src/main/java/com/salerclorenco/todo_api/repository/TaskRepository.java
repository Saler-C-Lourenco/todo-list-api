package com.salerclorenco.todo_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salerclorenco.todo_api.entity.TaskEntity;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {

}
