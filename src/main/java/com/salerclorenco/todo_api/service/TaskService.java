package com.salerclorenco.todo_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salerclorenco.todo_api.entity.Task;
import com.salerclorenco.todo_api.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	public Task save(Task task) {
		Task taskSaved = this.taskRepository.save(task);
		return taskSaved;
	}

	public List<Task> findAll() {
		List<Task> taskList = this.taskRepository.findAll();
		return taskList;
	}

	public Task findById(Long id) {
		if (id > 0) {
			Optional<Task> taskFound = this.taskRepository.findById(id);
			return taskFound.get();
		}
		return null;
	}

	public Task update(Long id, Task taskRequested) {
		if (this.findById(id) != null) {
			taskRequested.setId(id);
			Task taskUpdated = this.taskRepository.save(taskRequested);
			return taskUpdated;
		}

		return null;
	}

	public Task delete(Long id) {
		Task taskDeleted = this.findById(id);
		if (taskDeleted != null) {
			this.taskRepository.deleteById(id);
			return taskDeleted;
		}
		return null;
	}

}
