package com.salerclorenco.todo_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salerclorenco.todo_api.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
