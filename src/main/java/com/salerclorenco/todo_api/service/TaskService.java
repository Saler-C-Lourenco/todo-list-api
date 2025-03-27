package com.salerclorenco.todo_api.service;

import java.util.List;

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

	public List<TaskEntity> listAll() {
		List<TaskEntity> taskList = this.taskRepository.findAll();
		return taskList;
	}

	public TaskEntity findById(Long id) {
		TaskEntity taskFound = new TaskEntity();
		return taskFound;
	}

	public TaskEntity update(Long id, TaskEntity taskOriginal) {
		// TODO Auto-generated method stub
		return null;
	}

	public TaskEntity delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
