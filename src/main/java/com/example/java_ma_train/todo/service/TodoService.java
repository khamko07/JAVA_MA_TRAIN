package com.example.java_ma_train.todo.service;

import com.example.java_ma_train.todo.dto.CreateTodoRequest;
import com.example.java_ma_train.todo.dto.TodoResponse;
import com.example.java_ma_train.todo.dto.UpdateTodoRequest;
import com.example.java_ma_train.todo.exception.TodoNotFoundException;
import com.example.java_ma_train.todo.mapper.TodoMapper;
import com.example.java_ma_train.todo.model.Todo;
import com.example.java_ma_train.todo.repository.TodoRepository;
import com.example.java_ma_train.todo.validation.TodoValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;
    private final TodoMapper todoMapper;
    private final TodoValidator todoValidator;

    public TodoService(TodoRepository todoRepository, TodoMapper todoMapper, TodoValidator todoValidator) {
        this.todoRepository = todoRepository;
        this.todoMapper = todoMapper;
        this.todoValidator = todoValidator;
    }

    public List<TodoResponse> getAllTodos() {
        return todoRepository.findAll()
                .stream()
                .map(todoMapper::toResponse)
                .toList();
    }

    public TodoResponse getTodoById(Long id) {
        Todo todo = findExistingTodo(id);
        return todoMapper.toResponse(todo);
    }

    public TodoResponse createTodo(CreateTodoRequest request) {
        todoValidator.validateCreate(request);

        Todo todo = todoMapper.toEntity(request);
        Todo savedTodo = todoRepository.save(todo);

        return todoMapper.toResponse(savedTodo);
    }

    public TodoResponse updateTodo(Long id, UpdateTodoRequest request) {
        todoValidator.validateUpdate(request);

        Todo existingTodo = findExistingTodo(id);
        todoMapper.updateEntity(existingTodo, request);
        Todo savedTodo = todoRepository.save(existingTodo);

        return todoMapper.toResponse(savedTodo);
    }

    public void deleteTodo(Long id) {
        findExistingTodo(id);
        todoRepository.deleteById(id);
    }

    private Todo findExistingTodo(Long id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException(id));
    }
}

