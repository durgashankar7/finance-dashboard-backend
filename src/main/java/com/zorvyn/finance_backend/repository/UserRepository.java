package com.zorvyn.finance_backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zorvyn.finance_backend.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // Ye method hume email se user dhoondhne me madad karega (Login ke time pe)
    Optional<User> findByEmail(String email);
}