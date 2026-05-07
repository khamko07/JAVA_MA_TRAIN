package com.example.java_ma_train.todo.config;

import com.example.java_ma_train.todo.dto.CreateTodoRequest;
import com.example.java_ma_train.todo.service.TodoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleDataLoader implements CommandLineRunner {

    private final TodoService todoService;

    public SampleDataLoader(TodoService todoService) {
        this.todoService = todoService;
    }

    @Override
    public void run(String... args) {
        if (!todoService.getAllTodos().isEmpty()) {
            return;
        }

        todoService.createTodo(createRequest(
                "Học Java cơ bản",
                "Ôn lại biến, kiểu dữ liệu, if/else và vòng lặp."
        ));

        todoService.createTodo(createRequest(
                "Học Spring Boot",
                "Tìm hiểu @RestController, @Service và @Repository."
        ));

        todoService.createTodo(createRequest(
                "Thử gọi API",
                "Dùng trình duyệt hoặc Postman để test các endpoint CRUD."
        ));
    }

    private CreateTodoRequest createRequest(String title, String description) {
        CreateTodoRequest request = new CreateTodoRequest();
        request.setTitle(title);
        request.setDescription(description);
        return request;
    }
}

