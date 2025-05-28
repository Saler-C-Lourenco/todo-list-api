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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value  = "/task", produces = {"application/json"})
@Tag(name = "To-Do-List-API")
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@Operation(summary = "Cria novas tarefas", method = "POST")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Nova tarefa criada com sucesso."),
			@ApiResponse(responseCode = "400", description = "Houve algum erro.")
	})
	@PostMapping(value = "/save", consumes = "application/json")
	public ResponseEntity<Task> save (@RequestBody Task task){
		try {
			Task savedTask = this.taskService.save(task);
			return new ResponseEntity<Task>(savedTask, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@Operation(summary = "Busca todos os dados de tarefas cadastradas no banco de dados", method = "GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Busca realizada com sucesso."),
			@ApiResponse(responseCode = "400", description = "Houve algum erro.")
	})
	@GetMapping(value = "/findAll")
	public ResponseEntity<List<Task>> findAll(){
		try {
			List<Task> tasklList = this.taskService.findAll();
			return new ResponseEntity<List<Task>>(tasklList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@Operation(summary = "Busca uma tarefa específica cadastrada no banco de dados.", method = "GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Busca realizada com sucesso."),
			@ApiResponse(responseCode = "400", description = "Houve algum erro.")
	})
	@GetMapping(value = "/findById/{id}")
	public ResponseEntity<Task> findById (@PathVariable Long id){
		try {
			Task taskFound = this.taskService.findById(id);
			return new ResponseEntity<Task>(taskFound, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@Operation(summary = "Atualiza uma tarefa específica cadastrada no banco de dados com novas informações fornecidas pelo usuário", method = "PUT")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Tarefa atualizada com sucesso."),
			@ApiResponse(responseCode = "400", description = "Houve algum erro.")
	})
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<Task> update (@PathVariable Long id, @RequestBody Task taskRequested){
		try {
			Task taskUpdated = this.taskService.update(id, taskRequested);
			return new ResponseEntity<Task>(taskUpdated, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@Operation(summary = "Deleta uma tarefa específica cadastrada no banco de dados.", method = "DELETE")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Tarefa deletada com sucesso."),
			@ApiResponse(responseCode = "400", description = "Houve algum erro.")
	})
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Task> delete (@PathVariable Long id){
		try {
			Task taskDeleted = this.taskService.delete(id);
			return new ResponseEntity<Task>(taskDeleted, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
}
