package com.example.demo;

import org.springframework.data.repository.CrudRepository;

//import com.example.demo.DemoApplication;

// This will be AUTO IMPLEMENTED by Spring into a Bean called todoItemRepository
// CRUD refers Create, Read, Update, Delete

public interface TodoItemRepository extends CrudRepository<TodoItem, Integer> {

}