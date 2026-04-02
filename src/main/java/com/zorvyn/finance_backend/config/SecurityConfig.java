package com.zorvyn.finance_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Postman ke liye ise disable rakha hai
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/users/register").permitAll() // Register koi bhi kar sakta hai
                
                // ASLI RULES YAHAN HAIN:
                .requestMatchers(HttpMethod.GET, "/api/records/**").hasAnyRole("VIEWER", "ANALYST", "ADMIN")
                .requestMatchers(HttpMethod.POST, "/api/records/**").hasAnyRole("ANALYST", "ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/api/records/**").hasRole("ADMIN")
                
                .anyRequest().authenticated()
            )
            .httpBasic(withDefaults()); // Ye Postman me login mangne ke liye hai
            
        return http.build();
    }

    // Password match karne ke liye (Kyunki humne plain password 'securepassword123' use kiya hai)
    @SuppressWarnings("deprecation")
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance(); 
    }
}