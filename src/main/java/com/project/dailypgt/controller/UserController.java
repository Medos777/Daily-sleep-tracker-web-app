package com.project.dailypgt.controller;

import com.project.dailypgt.model.User;
import com.project.dailypgt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public long create(@Validated @RequestBody User user){
       return userService.create(user);
       // System.out.println("in controller");

    }
    @GetMapping("/users/{user_id}")
    public User findUserById(@PathVariable(value = "user_id") long user_id){
        return userService.findById(user_id);
    }
}
