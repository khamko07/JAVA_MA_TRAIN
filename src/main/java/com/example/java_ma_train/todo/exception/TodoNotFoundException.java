package com.example.java_ma_train.todo.exception;

public class TodoNotFoundException extends RuntimeException {

    public TodoNotFoundException(Long id) {
        super("Không tìm thấy todo với id = " + id);
    }
}

