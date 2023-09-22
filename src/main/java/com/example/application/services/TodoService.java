package com.example.application.services;

import com.example.application.db.Todo;
import com.example.application.db.TodoRepository;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import dev.hilla.BrowserCallable;

import java.util.List;

@BrowserCallable
@AnonymousAllowed
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }
}
