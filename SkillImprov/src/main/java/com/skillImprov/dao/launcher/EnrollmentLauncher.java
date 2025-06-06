package com.skillImprov.dao.launcher;

import com.skillImprov.dao.interfaces.CourseDao;
import com.skillImprov.dao.interfaces.EnrollmentDao;
import com.skillImprov.dao.interfaces.UserDao;
import com.skillImprov.entity.Course;
import com.skillImprov.entity.Enrollment;
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
public class EnrollmentLauncher {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(EnrollmentLauncher.class, args);

        // Get DAO beans
        UserDao userDao = context.getBean(UserDao.class);
        CourseDao courseDao = context.getBean(CourseDao.class);
        EnrollmentDao enrollmentDao = context.getBean(EnrollmentDao.class);

        // Create a new user
        User user = context.getBean(User.class);
        user.setUsername("alex");
        user.setEmail("alex@gmail.com");
        user.setPassword("alex123");
        userDao.save(user);

        // Create a new course
        Course course = context.getBean(Course.class);
        course.setTitle("Java Basics");
        course.setDescription("Introductory Java course");
        course.setThumbnailUrl("http://example.com/java.jpg");
        course.setCategory("Programming");
        course.setDifficultyLevel(DifficultyLevel.BEGINNER);
        course.setStatus(VideoStatus.PUBLISHED);
        course.setUser(user);
        courseDao.save(course);

        // Enroll the user in the course
        Enrollment enrollment = context.getBean(Enrollment.class);
        enrollment.setUser(user);
        enrollment.setCourse(course);
        enrollment.setEnrolledAt(java.time.LocalDateTime.now());
        enrollment.setCompleted(false);
        enrollmentDao.save(enrollment);
        System.out.println("Enrollment saved!");

        // Fetch and print
        Optional<Enrollment> fetchedEnrollment = enrollmentDao.findById(enrollment.getEnrollmentId());
        System.out.println("Fetched Enrollment: " + fetchedEnrollment.orElse(null));
    }
}
