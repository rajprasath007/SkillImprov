package com.skillImprov.dao.launcher;

import com.skillImprov.dao.interfaces.NotificationDao;
import com.skillImprov.dao.interfaces.UserDao;
import com.skillImprov.entity.Notification;
import com.skillImprov.entity.User;
import com.skillImprov.enums.NotificationType;
import com.skillImprov.enums.Role;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootApplication(scanBasePackages = "com.skillImprov")
@EnableJpaRepositories(basePackages = "com.skillImprov.dao.interfaces")
@EntityScan(basePackages = "com.skillImprov.entity")
public class NotificationLauncher {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(NotificationLauncher.class, args);

        UserDao userDao = context.getBean(UserDao.class);
        NotificationDao notificationDao = context.getBean(NotificationDao.class);

        // Create and save user
        User user = context.getBean(User.class);
        user.setUsername("mark");
        user.setEmail("mark@gmail.com");
        user.setPassword("mark123");
        user.setRole(Role.STUDENT);
        userDao.save(user);

        // Create and save notification
        Notification notification = context.getBean(Notification.class);
        notification.setUser(user);
        notification.setMessage("Welcome to SkillImprov!");
        notification.setSeen(false);
        notification.setType(NotificationType.REMINDER);
        notification.setCreatedAt(LocalDateTime.now());
        notificationDao.save(notification);
        System.out.println("Notification saved!");

        // Fetch and print notification
        Optional<Notification> fetchedNotification = notificationDao.findById(notification.getNotificationId());
        System.out.println("Fetched Notification: " + fetchedNotification.orElse(null));
    }
}
