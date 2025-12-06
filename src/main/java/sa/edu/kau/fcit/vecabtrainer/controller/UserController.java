package sa.edu.kau.fcit.vecabtrainer.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import sa.edu.kau.fcit.vecabtrainer.model.User;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping
    public void createUser(@RequestBody User user) {
        System.out.println("User ID: " + user.getUserId());
    }
}