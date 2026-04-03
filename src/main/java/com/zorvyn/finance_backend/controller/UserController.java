package com.zorvyn.finance_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zorvyn.finance_backend.entity.User;
import com.zorvyn.finance_backend.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Naya user banane ka endpoint (POST request)
    @PostMapping("/register")
public ResponseEntity<User> registerUser(@RequestBody User user) {
    // handle user registration flow
    System.out.println("Registering new user: " + user.getEmail()); 
    User savedUser = userService.createUser(user);
    return ResponseEntity.ok(savedUser);
}

    // Saare users ki list dekhne ka endpoint (GET request)
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}