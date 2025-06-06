package com.skillImprov.dao.launcher;

import com.skillImprov.dao.interfaces.CourseDao;
import com.skillImprov.dao.interfaces.UserDao;
import com.skillImprov.entity.Course;
import com.skillImprov.entity.User;
import com.skillImprov.enums.DifficultyLevel;
import com.skillImprov.enums.VideoStatus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import java.util.Optional;

@SpringBootApplication(scanBasePackages = {"com.skillImprov"})
@EnableJpaRepositories(basePackages = "com.skillImprov.dao.interfaces")
@EntityScan(basePackages = "com.skillImprov.entity")
public class CourseLauncher {

    public static void main(String[] args) {
        // Start Spring context
        ApplicationContext context = SpringApplication.run(CourseLauncher.class, args);

        // Get the DAO beans
        CourseDao courseDao = context.getBean(CourseDao.class);
        UserDao userDao = context.getBean(UserDao.class);

        // Create or fetch a user
        User user = context.getBean(User.class);
        user.setUsername("raj");
        user.setEmail("raj@gmail.com");
        user.setPassword("raj123");
        userDao.save(user);

        // Create and save a course
        Course course = context.getBean(Course.class);
        course.setTitle("Spring Boot for Beginners");
        course.setDescription("Learn Spring Boot from scratch.");
        course.setThumbnailUrl("http://example.com/thumbnail.jpg");
        course.setCategory("Backend Development");
        course.setDifficultyLevel(DifficultyLevel.BEGINNER);
        course.setStatus(VideoStatus.PUBLISHED);
        course.setUser(user);

        courseDao.save(course);
        System.out.println("Course saved!");

        // Fetch and display the saved course
        Optional<Course> fetchedCourse = courseDao.findById(course.getCourseId());
        System.out.println("Fetched Course: " + fetchedCourse.orElse(null));
    }
}
