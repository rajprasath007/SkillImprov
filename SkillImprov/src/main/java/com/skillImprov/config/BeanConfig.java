package com.skillImprov.config;

import java.time.LocalDateTime;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.skillImprov.entity.User;
import com.skillImprov.enums.Role;

@Configuration
@ComponentScan(basePackages="com.skillImprov.entity")

public class BeanConfig {
	@Bean
    public User user() {
		User user = new User();
		
		user.setUsername("lusu");
		user.setEmail("lusu@koothi.com");
		user.setPassword("lusuPunda123"); // typically should be hashed
		user.setRole(Role.INSTRUCTOR); // or Role.ADMIN, Role.INSTRUCTOR, etc.
		user.setCreatedAt(LocalDateTime.now());
		user.setLastLogin(LocalDateTime.now());
		return user; 
		

        
    }

}
