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

    @PostMapping(path = "/validateUser")
    @ResponseBody
    Response validateUser(@RequestBody User user) {
        Iterable<User> allUsers = userRepository.findAll();

        for (User curUser : allUsers) {
            System.out.println(curUser.getUsername());
            if (user.getUsername().equals(curUser.getUsername())) {
                if (user.getPassword().equals(curUser.getPassword())) {
                    return buildMessageResponse("0", "Login successful");
                }
                return buildMessageResponse("FAIL_1", "Password incorrect");
            }
        }
        return buildMessageResponse("FAIL_2", "Login unsuccessful");
    }

    public Response buildMessageResponse(String infoId, String message) {
        Response response = new Response(infoId);

        Body body = new Body();
        body.setMessage(message);
        response.setBody(body);
        return response;
    }

}
