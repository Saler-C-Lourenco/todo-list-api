package com.salerclorenco.todo_api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.salerclorenco.todo_api.entity.TaskEntity;

@Service
public class TaskService {

	public TaskEntity save(TaskEntity task) {
		return task;
	}

	public List<TaskEntity> listAll() {
		List<TaskEntity> taskList = new ArrayList<>();
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
