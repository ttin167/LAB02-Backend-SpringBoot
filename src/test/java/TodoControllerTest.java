package org.example.lab02;

import org.example.lab02.pojos.Todo;
import org.example.lab02.services.TodoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.Optional;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class TodoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TodoService todoService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testGetTodos() throws Exception {
        Todo todo1 = new Todo(1L, "Task 1", false);
        Todo todo2 = new Todo(2L, "Task 2", true);
        when(todoService.getAllTodos()).thenReturn(Arrays.asList(todo1, todo2));

        mockMvc.perform(get("/todos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Task 1"))
                .andExpect(jsonPath("$[1].title").value("Task 2"));
    }

    @Test
    void testGetTodoById() throws Exception {
        Todo todo = new Todo(1L, "Sample Task", false);
        when(todoService.getTodoById(1L)).thenReturn(todo);

        mockMvc.perform(get("/todos/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Sample Task"));
    }

    @Test
    void testCreateTodo() throws Exception {
        Todo newTodo = new Todo(null, "New Task", false);
        Todo savedTodo = new Todo(1L, "New Task", false);
        when(todoService.createTodo(any(Todo.class))).thenReturn(savedTodo);

        mockMvc.perform(post("/todos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newTodo)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("New Task"));
    }

    @Test
    void testUpdateTodo() throws Exception {
        Todo updatedTodo = new Todo(1L, "Updated Task", true);
        when(todoService.updateTodo(eq(1L), any(Todo.class))).thenReturn(updatedTodo);

        mockMvc.perform(put("/todos/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedTodo)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Updated Task"));
    }


}