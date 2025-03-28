package com.salerclorenco.todo_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salerclorenco.todo_api.entity.TaskEntity;
import com.salerclorenco.todo_api.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@PostMapping("/save")
	public ResponseEntity<TaskEntity> save (@RequestBody TaskEntity task){
		try {
			TaskEntity savedTask = this.taskService.save(task);
			return new ResponseEntity<TaskEntity>(savedTask, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<TaskEntity>> findAll(){
		try {
			List<TaskEntity> tasklList = this.taskService.findAll();
			return new ResponseEntity<List<TaskEntity>>(tasklList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<TaskEntity> findById (@PathVariable Long id){
		try {
			TaskEntity taskFound = this.taskService.findById(id);
			return new ResponseEntity<TaskEntity>(taskFound, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<TaskEntity> update (@PathVariable Long id, @RequestBody TaskEntity taskRequested){
		try {
			TaskEntity taskUpdated = this.taskService.update(id, taskRequested);
			return new ResponseEntity<TaskEntity>(taskUpdated, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<TaskEntity> delete (@PathVariable Long id){
		try {
			TaskEntity taskDeleted = this.taskService.delete(id);
			return new ResponseEntity<TaskEntity>(taskDeleted, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
}
