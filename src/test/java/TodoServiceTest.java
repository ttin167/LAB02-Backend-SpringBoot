package org.example.lab02;

import org.example.lab02.pojos.Todo;
import org.example.lab02.services.TodoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TodoServiceTest {
    @InjectMocks
    private TodoService todoService;

    private Todo sampleTodo;

    @BeforeEach
    void setUp() {
        sampleTodo = new Todo();
        sampleTodo.setId(1L);
        sampleTodo.setTitle("Test Todo");
        sampleTodo.setCompleted(false);
        todoService.createTodo(sampleTodo);
    }



    @Test
    void testCreateTodoThrowException() {
        Todo invalidTodo = new Todo();
        assertThrows(IllegalArgumentException.class, () -> todoService.createTodo(invalidTodo));
    }

    @Test
    void testGetTodoById() {
        Todo foundTodo = todoService.getTodoById(1L);
        assertNotNull(foundTodo);
        assertEquals("Test Todo", foundTodo.getTitle());
    }

    @Test
    void testUpdateTodo() {
        Todo updatedTodo = new Todo();
        updatedTodo.setTitle("Updated Todo");
        updatedTodo.setCompleted(true);
        Todo result = todoService.updateTodo(1L, updatedTodo);
        assertEquals("Updated Todo", result.getTitle());
    }



    @Test
    void testDeleteTodo() {
        todoService.deleteTodo(1L);
        assertNull(todoService.getTodoById(1L));
    }
}