package org.example.lab02.services;

import org.example.lab02.pojos.Todo;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class TodoService {
    private final Map<Long, Todo> todos = new HashMap<>();
    private long idCounter = 1;

    public Collection<Todo> getAllTodos() {
        return todos.values();
    }

    public Todo createTodo(Todo todo) {
        if (todo.getTitle() == null || todo.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        todo.setId(idCounter++);
        todos.put(todo.getId(), todo);
        return todo;
    }

    public Todo getTodoById(Long id) {
        return todos.get(id);
    }

    public Todo updateTodo(Long id, Todo updatedTodo) {
        if (!todos.containsKey(id)) {
            throw new NoSuchElementException("Todo not found");
        }
        if (updatedTodo.getTitle() == null || updatedTodo.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        updatedTodo.setId(id);
        todos.put(id, updatedTodo);
        return updatedTodo;
    }

    public void deleteTodo(Long id) {
        todos.remove(id);
    }
}