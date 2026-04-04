package com.zorvyn.finance_backend.config;

import com.zorvyn.finance_backend.entity.User;
import com.zorvyn.finance_backend.entity.Role; // Apna Role enum import karein
import com.zorvyn.finance_backend.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner loadData(UserRepository userRepository) {
        return args -> {
            // Check karega ki kya admin pehle se database mein hai
            if (userRepository.findByEmail("admin@zorvyn.com").isEmpty()) {
                
                // 1. ADMIN Account
                User admin = new User();
                admin.setEmail("admin@zorvyn.com");
                admin.setPassword("admin123");
                admin.setRole(Role.ADMIN);
                admin.setActive(true);
                userRepository.save(admin);

                // 2. ANALYST Account
                User analyst = new User();
                analyst.setEmail("analyst@zorvyn.com");
                analyst.setPassword("analyst123");
                analyst.setRole(Role.ANALYST);
                analyst.setActive(true);
                userRepository.save(analyst);

                // 3. VIEWER Account
                User viewer = new User();
                viewer.setEmail("viewer@zorvyn.com");
                viewer.setPassword("viewer123");
                viewer.setRole(Role.VIEWER);
                viewer.setActive(true);
                userRepository.save(viewer);

                System.out.println("Default Test Users Created Automatically! 🎉");
            }
        };
    }
}