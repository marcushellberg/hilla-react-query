package com.example.application.db;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Todo {

    @Id
    @GeneratedValue
    private Long id;
    private String task;
    private boolean done;

    public Todo() {
    }

    public Todo(String task, boolean done) {
        this.task = task;
        this.done = done;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public boolean isDone() {
        return done;
    }

    public void setTask(String title) {
        this.task = title;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
