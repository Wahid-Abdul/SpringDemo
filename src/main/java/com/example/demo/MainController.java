package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*") // Allows requests from all sources
@Controller // This means that this class is a Controller
@RequestMapping(path = "/todo") // This means URL's start with /demo (after Application path)
public class MainController {

    @Autowired
    private TodoItemRepository todoItemRepository;
    @PostMapping(path = "/add") // Map ONLY POST Requests
    public @ResponseBody
    String addTask(@RequestBody TodoItem todoItem) {
        // @ResponseBody means the returned String is the response, not a view name

        todoItemRepository.save(todoItem);
        return "Saved";
    }

    @PostMapping(path = "/updateTasks") // Map ONLY POST Requests
    public @ResponseBody
    Response updateTasks(@RequestBody TodoItem[] todoItems) {
        // @ResponseBody means the returned String is the response, not a view name
        for (int i = 0; i < todoItems.length; i++) {
            todoItemRepository.save(todoItems[i]);
        }

        return buildMessageResponse("0", String.format("Updated %s items", todoItems.length));
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Response getAllTasks() {
        // This returns a JSON or XML with the users
        Response response = buildMessageResponse("0", "We've given you all we got");
        Body body = response.getBody();
        body.setTodoList(todoItemRepository.findAll());
        response.setBody(body);
        return response;
    }

    @PostMapping(path = "/myTodos")
    public @ResponseBody
    Response getMyTasks(@RequestBody TodoItem todoItem) {

        Response response = buildMessageResponse("0", "These are all yours.");

        Body body = response.getBody();
        body.setTodoList(todoItemRepository.findByUsername(todoItem.getUsername()));

        response.setBody(body);
        return response;
    }

    @PostMapping(path = "/delete") // Map ONLY POST Requests
    public @ResponseBody
    String deleteOneItem(@RequestBody TodoItem todoItem) {
        // @ResponseBody means the returned String is the response, not a view name

        try {
            todoItemRepository.deleteById(todoItem.getId());
            return "Deleted";
        } catch (Exception error) {
            System.out.println(error);
            return "Item does not exist";
        }
    }

    @PostMapping(path = "/deleteAll") // Map ONLY POST Requests
    public @ResponseBody
    String deleteAll() {
        try {
            todoItemRepository.deleteAll();
            return "All entries have been deleted";
        } catch (Exception error) {
            System.out.println(error);
            return "Something went wrong";
        }
    }

    @PostMapping(path = "/deleteTasks")
    public @ResponseBody
    Response deleteTasks(@RequestBody TodoItem[] todoItems) {

        try {

            for (int i = 0; i < todoItems.length; i++) {
                todoItemRepository.deleteById(todoItems[i].getId());
            }

            return buildMessageResponse("0", String.format("Deleted %s items", todoItems.length));
        } catch (Exception error) {
            System.out.println(error);
            return buildMessageResponse("ERROR 4", "Deletion went wrong");
        }


    }

    private Response buildMessageResponse(String infoId, String message) {
        Response response = new Response(infoId);

        Body body = new Body();
        body.setMessage(message);
        response.setBody(body);
        return response;
    }
}
