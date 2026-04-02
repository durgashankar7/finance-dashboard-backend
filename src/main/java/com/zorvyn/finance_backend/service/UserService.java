package com.zorvyn.finance_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zorvyn.finance_backend.entity.User;
import com.zorvyn.finance_backend.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Naya user create karne ke liye
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Saare users ki list nikalne ke liye
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Email se user dhoondhne ke liye (Login ke time kaam aayega)
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}