package com.learn.fullstackapplication.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.fullstackapplication.entity.Todo;
import com.learn.fullstackapplication.service.TodoService;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class TodoController {

	@Autowired
	private TodoService todoService;

	Logger logger = LoggerFactory.getLogger(TodoController.class);

	@GetMapping(value = "/todos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getTodos() {
		try {
			List<Todo> allTodos = todoService.getAllTodos();
			return ResponseEntity.ok().body(allTodos);
		} catch (RuntimeException e) {
			logger.info("", e.getMessage());
			return new ResponseEntity<>(Map.of("Message", "No Todo Found"), HttpStatus.OK);
		}
	}

	@GetMapping(value = "/todos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getTodoById(@PathVariable int id) {
		try {
			Optional<Todo> todo = todoService.getTodoById(id);
			if (todo.isPresent()) {
				return ResponseEntity.ok().body(todo.get());
			} else {
				return new ResponseEntity<>("Not Todo Found", HttpStatus.OK);
			}
		} catch (RuntimeException e) {
			logger.info("", e.getMessage());
			return new ResponseEntity<>(Map.of("Message", "No Todo Found"), HttpStatus.OK);

		}
	}

	@PostMapping(value = "/todos")
	public ResponseEntity<?> saveTodos(@RequestBody Todo todo) {
		try {
			System.out.println(todo.toString());
			Todo savedTodo = todoService.saveTodo(todo);
			return ResponseEntity.ok().body(savedTodo);
		} catch (Exception e) {
			logger.info("", e.getMessage());
			return new ResponseEntity<>(Map.of("Message", "Something Wrong... Todo Not Saved"), HttpStatus.OK);
		}
	}

	@PutMapping(value = "/todos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateTodo(@RequestBody Todo todo) {
		try {
			Todo updatedTodo = todoService.updateTodo(todo);
			return ResponseEntity.ok().body(updatedTodo);
		} catch (RuntimeException e) {
			logger.info("", e.getMessage());
			return new ResponseEntity<>(Map.of("Message", "Something Wrong... Todo Not Updated"), HttpStatus.OK);
		}

	}

	@DeleteMapping(value = "/todos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteTodo(@PathVariable int id) {
		try {
			todoService.deleteTodo(id);
			return new ResponseEntity<>(Map.of("msg", "Todo Deleted Success"), HttpStatus.OK);
		} catch (RuntimeException e) {
			logger.info("", e.getMessage());
			return new ResponseEntity<>(Map.of("Message", "Something Wrong... Todo Not Deleted"), HttpStatus.OK);
		}
	}

}
