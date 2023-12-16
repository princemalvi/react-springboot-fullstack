package com.learn.fullstackapplication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.fullstackapplication.entity.Todo;
import com.learn.fullstackapplication.repo.TodoRepository;


@Service
public class TodoService {

	static List<Todo> listTodos = new ArrayList<>();
	
	
	@Autowired
	private TodoRepository todoRepository;
	
	public List<Todo> getAllTodos(){
		return todoRepository.findAll();
	}
	
	public Optional<Todo> getTodoById(int id) {
		return todoRepository.findById(id);
	}

	public void deleteTodo(int id) {
		Optional<Todo> todo = todoRepository.findById(id);
		if(todo.isPresent()) {
			todoRepository.delete(todo.get());
		}
	}
	
	public Todo saveTodo(Todo todo) {
		return todoRepository.save(todo);
	}
	
	public Todo updateTodo(Todo todo) {
		return todoRepository.save(todo);
	}
}
