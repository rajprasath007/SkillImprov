package com.skillImprov.dao.launcher;

import com.skillImprov.dao.interfaces.UserDao;
import com.skillImprov.entity.User;
import com.skillImprov.enums.Role;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;


@SpringBootApplication(scanBasePackages = {"com.skillImprov"})
@EnableJpaRepositories(basePackages = "com.skillImprov.dao.interfaces")
@EntityScan(basePackages = "com.skillImprov.entity")
public class UserLauncher {

    public static void main(String[] args) {
        // Start the Spring context
        ApplicationContext context = SpringApplication.run(UserLauncher.class, args);

        // Get the UserDao bean from the context
        UserDao userDao = context.getBean(UserDao.class);

        // Create and save a user
        User user = context.getBean(User.class);
        user.setUsername("raj");
        user.setEmail("punda@gmail.com");
        user.setPassword("raj12345");
        user.setRole(Role.STUDENT);
        userDao.save(user);
        System.out.println("User saved!");

        // Fetch the user back
        Optional<User> fetchedUser = userDao.findById(user.getUserId());
        System.out.println("User fetched: " + fetchedUser.orElse(null));
    }
}
