package com.skillImprov.config;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.skillImprov.entity.User;
import com.skillforge.authservice.model.Role;

@Configuration
@ComponentScan(basePackages="com.skillImprov.entity")

public class BeanConfig {
	@Bean
    public User user() {
		User user = new User();

		user.setUserId(1);
		user.setUsername("john_doe");
		user.setEmail("john.doe@example.com");
		user.setPassword("securePassword123"); // typically should be hashed
		user.setRole(Role.STUDENT); // or Role.ADMIN, Role.INSTRUCTOR, etc.
		user.setCreatedAt(LocalDateTime.now());
		user.setLastLogin(LocalDateTime.now());
		return user; 
		

        
    }

}
