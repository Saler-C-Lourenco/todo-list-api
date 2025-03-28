package com.salerclorenco.todo_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salerclorenco.todo_api.entity.TaskEntity;
import com.salerclorenco.todo_api.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	public TaskEntity save(TaskEntity task) {
		TaskEntity taskSaved = this.taskRepository.save(task);
		return taskSaved;
	}

	public List<TaskEntity> findAll() {
		List<TaskEntity> taskList = this.taskRepository.findAll();
		return taskList;
	}

	public TaskEntity findById(Long id) {
		if (id > 0) {
			Optional<TaskEntity> taskFound = this.taskRepository.findById(id);
			return taskFound.get();
		}
		return null;
	}

	public TaskEntity update(Long id, TaskEntity taskRequested) {
		if (this.findById(id) != null) {
			taskRequested.setId(id);
			TaskEntity taskUpdated = this.taskRepository.save(taskRequested);
			return taskUpdated;
		}

		return null;
	}

	public TaskEntity delete(Long id) {
		TaskEntity taskDeleted = this.findById(id);
		if (taskDeleted != null) {
			this.taskRepository.deleteById(id);
			return taskDeleted;
		}
		return null;
	}

}
