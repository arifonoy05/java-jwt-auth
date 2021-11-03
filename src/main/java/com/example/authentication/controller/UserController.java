package com.example.authentication.controller;

import com.example.authentication.domain.User;
import com.example.authentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;

    @PostConstruct
    public void initAdmin(){
        userService.initAdmin();
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @PostMapping
    public User registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }
}
