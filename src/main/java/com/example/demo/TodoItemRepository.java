package com.example.demo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

//import com.example.demo.DemoApplication;

// This will be AUTO IMPLEMENTED by Spring into a Bean called todoItemRepository
// CRUD refers Create, Read, Update, Delete

public interface TodoItemRepository extends CrudRepository<TodoItem, Integer> {

    public Iterable<TodoItem> findByUsername(String username);

    @Modifying
    @Transactional
    @Query(value="delete from todo_item r where r.username = ?1 and r.content= ?2", nativeQuery = true)
    void deleteByParameters(String username, String content);
}