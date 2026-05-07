package com.example.java_ma_train.todo.validation;

import com.example.java_ma_train.todo.dto.CreateTodoRequest;
import com.example.java_ma_train.todo.dto.UpdateTodoRequest;
import org.springframework.stereotype.Component;

@Component
public class TodoValidator {

    public void validateCreate(CreateTodoRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Request body không được để trống.");
        }

        validateTitle(request.getTitle());
        validateDescription(request.getDescription());
    }

    public void validateUpdate(UpdateTodoRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Request body không được để trống.");
        }

        validateTitle(request.getTitle());
        validateDescription(request.getDescription());

        if (request.getStatus() == null) {
            throw new IllegalArgumentException("Status không được để trống.");
        }
    }

    private void validateTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title không được để trống.");
        }

        if (title.length() > 100) {
            throw new IllegalArgumentException("Title không được dài quá 100 ký tự.");
        }
    }

    private void validateDescription(String description) {
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description không được để trống.");
        }

        if (description.length() > 255) {
            throw new IllegalArgumentException("Description không được dài quá 255 ký tự.");
        }
    }
}

