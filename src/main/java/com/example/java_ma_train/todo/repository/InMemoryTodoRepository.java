package com.example.java_ma_train.todo.repository;

import com.example.java_ma_train.todo.model.Todo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryTodoRepository implements TodoRepository {

    private final Map<Long, Todo> todoStore = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong(0);

    @Override
    public List<Todo> findAll() {
        List<Todo> todos = new ArrayList<>(todoStore.values());
        todos.sort(Comparator.comparing(Todo::getId));
        return todos;
    }

    @Override
    public Optional<Todo> findById(Long id) {
        return Optional.ofNullable(todoStore.get(id));
    }

    @Override
    public Todo save(Todo todo) {
        if (todo.getId() == null) {
            todo.setId(nextId.incrementAndGet());
        }

        todoStore.put(todo.getId(), todo);
        return todo;
    }

    @Override
    public void deleteById(Long id) {
        todoStore.remove(id);
    }
}

