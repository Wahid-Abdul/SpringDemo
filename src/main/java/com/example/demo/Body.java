package com.example.demo;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL) // Does not return null values
public class Body {
    private String message;
    private Iterable<TodoItem> todoList;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Iterable<TodoItem> getTodoList() {
        return todoList;
    }

    public void setTodoList(Iterable<TodoItem> todoList) {
        this.todoList = todoList;
    }

}

