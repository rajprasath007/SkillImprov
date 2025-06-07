package com.skillImprov.dao.launcher;

import com.skillImprov.dao.interfaces.CourseDao;
import com.skillImprov.dao.interfaces.LessonDao;
import com.skillImprov.dao.interfaces.UserDao;
import com.skillImprov.entity.Course;
import com.skillImprov.entity.Lesson;
import com.skillImprov.entity.User;
import com.skillImprov.enums.ContentType;
import com.skillImprov.enums.DifficultyLevel;
import com.skillImprov.enums.Role;
import com.skillImprov.enums.VideoStatus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootApplication(scanBasePackages = "com.skillImprov")
@EntityScan(basePackages = "com.skillImprov.entity")
public class LessonLauncher {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(LessonLauncher.class, args);

        // DAOs
        UserDao userDao = context.getBean(UserDao.class);
        CourseDao courseDao = context.getBean(CourseDao.class);
        LessonDao lessonDao = context.getBean(LessonDao.class);

        // Create and save a user
        User user = context.getBean(User.class);
        user.setUsername("emma");
        user.setEmail("emma1@gmail.com");
        user.setPassword("emma123");
        user.setRole(Role.INSTRUCTOR);
        userDao.save(user);

        // Create and save a course
        Course course = context.getBean(Course.class);
        course.setTitle("Spring Boot Basics");
        course.setDescription("Learn Spring Boot from scratch");
        course.setThumbnailUrl("http://example.com/springboot.png");
        course.setCategory("Backend");
        course.setDifficultyLevel(DifficultyLevel.INTERMEDIATE);
        course.setStatus(VideoStatus.PUBLISHED);
        course.setUser(user);
        courseDao.save(course);

        // Create and save a lesson
        Lesson lesson = context.getBean(Lesson.class);
        lesson.setCourse(course);
        lesson.setTitle("Introduction to Spring Boot");
        lesson.setCreatedAt(LocalDateTime.now());
        lesson.setVideoUrl("http://example.com/springboot_intro.mp4");
        lesson.setOrderIndex(1);
        lesson.setContentType(ContentType.VIDEO);
        lessonDao.save(lesson);
        System.out.println("Lesson saved!");

        // Fetch and print the lesson
        Optional<Lesson> fetchedLesson = lessonDao.findById(lesson.getLessonId());
        System.out.println("Fetched Lesson: " + fetchedLesson.orElse(null));
    }
}
