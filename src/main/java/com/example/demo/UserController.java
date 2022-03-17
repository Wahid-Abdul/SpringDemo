package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*") // Allows requests from all sources
@Controller // This means that this class is a Controller
@RequestMapping(path = "/user") // This means URL's start with /demo (after Application path)
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/add")
    public @ResponseBody
    String addUser(@RequestBody User user) {


        userRepository.save(user);
        return "User mocky added";
    }
}
