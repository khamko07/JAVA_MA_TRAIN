package com.example.java_ma_train.todo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class AppInfoController {

    @GetMapping("/")
    public Map<String, Object> home() {
        return Map.of(
                "project", "JAVA_MA_TRAIN",
                "message", "Chào mừng bạn đến với dự án Spring Boot học CRUD cơ bản.",
                "suggestedSteps", List.of(
                        "Gọi GET /api/todos để xem dữ liệu mẫu",
                        "Gọi GET /api/todos/1 để xem chi tiết 1 công việc",
                        "Gọi POST /api/todos để tạo công việc mới",
                        "Gọi PUT /api/todos/{id} để cập nhật công việc",
                        "Gọi DELETE /api/todos/{id} để xóa công việc"
                )
        );
    }
}

