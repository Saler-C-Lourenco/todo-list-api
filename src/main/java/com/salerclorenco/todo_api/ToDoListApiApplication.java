package com.salerclorenco.todo_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
		title = "To-Do-List-API", 
		version = "1", 
		description = "Uma API RESTful para gerenciamento de tarefas, permitindo criação, atualização, listagem e exclusão de tarefas."))
public class ToDoListApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoListApiApplication.class, args);
	}

}
