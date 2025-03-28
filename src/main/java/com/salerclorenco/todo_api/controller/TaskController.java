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

import com.salerclorenco.todo_api.entity.Task;
import com.salerclorenco.todo_api.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@PostMapping("/save")
	public ResponseEntity<Task> save (@RequestBody Task task){
		try {
			Task savedTask = this.taskService.save(task);
			return new ResponseEntity<Task>(savedTask, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Task>> findAll(){
		try {
			List<Task> tasklList = this.taskService.findAll();
			return new ResponseEntity<List<Task>>(tasklList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Task> findById (@PathVariable Long id){
		try {
			Task taskFound = this.taskService.findById(id);
			return new ResponseEntity<Task>(taskFound, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Task> update (@PathVariable Long id, @RequestBody Task taskRequested){
		try {
			Task taskUpdated = this.taskService.update(id, taskRequested);
			return new ResponseEntity<Task>(taskUpdated, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Task> delete (@PathVariable Long id){
		try {
			Task taskDeleted = this.taskService.delete(id);
			return new ResponseEntity<Task>(taskDeleted, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
}
