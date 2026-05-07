package com.example.java_ma_train.todo.mapper;

import com.example.java_ma_train.todo.dto.CreateTodoRequest;
import com.example.java_ma_train.todo.dto.TodoResponse;
import com.example.java_ma_train.todo.dto.UpdateTodoRequest;
import com.example.java_ma_train.todo.model.Todo;
import com.example.java_ma_train.todo.model.TodoStatus;
import org.springframework.stereotype.Component;

@Component
public class TodoMapper {

    public Todo toEntity(CreateTodoRequest request) {
        Todo todo = new Todo();
        todo.setTitle(request.getTitle());
        todo.setDescription(request.getDescription());
        todo.setStatus(TodoStatus.TODO);
        return todo;
    }

    public void updateEntity(Todo todo, UpdateTodoRequest request) {
        todo.setTitle(request.getTitle());
        todo.setDescription(request.getDescription());
        todo.setStatus(request.getStatus());
    }

    public TodoResponse toResponse(Todo todo) {
        return new TodoResponse(
                todo.getId(),
                todo.getTitle(),
                todo.getDescription(),
                todo.getStatus()
        );
    }
}

