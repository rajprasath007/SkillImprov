package com.skillImprov.dao.launcher;

import com.skillImprov.dao.interfaces.CourseDao;
import com.skillImprov.dao.interfaces.LessonDao;
import com.skillImprov.dao.interfaces.QuizAttemptDao;
import com.skillImprov.dao.interfaces.QuizDao;
import com.skillImprov.dao.interfaces.UserDao;
import com.skillImprov.entity.Course;
import com.skillImprov.entity.Lesson;
import com.skillImprov.entity.Quiz;
import com.skillImprov.entity.QuizAttempt;
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

@SpringBootApplication(scanBasePackages = "com.skillImprov")
@EntityScan(basePackages = "com.skillImprov.entity")
public class QuizAttemptLauncher {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(QuizAttemptLauncher.class, args);

        UserDao userDao = context.getBean(UserDao.class);
        QuizDao quizDao = context.getBean(QuizDao.class);
        QuizAttemptDao quizAttemptDao = context.getBean(QuizAttemptDao.class);
        CourseDao courseDao = context.getBean(CourseDao.class);
        LessonDao lessonDao = context.getBean(LessonDao.class);

        // Create User
        User user = context.getBean(User.class);
        user.setUsername("quiz_user2");
        user.setEmail("quiz_user3@example.com");
        user.setPassword("password");
        user.setRole(Role.STUDENT);
        user.setCreatedAt(LocalDateTime.now());
        userDao.save(user);
        
        // Create Course
        Course course = context.getBean(Course.class);
        course.setCategory("skill");
        course.setCreatedAt(LocalDateTime.now());
        course.setDescription("paravaiyai parandhavan iragu pol karaigiren");
        course.setDifficultyLevel(DifficultyLevel.BEGINNER);
        course.setStatus(VideoStatus.PUBLISHED);
        course.setThumbnailUrl("");
        course.setTitle("Semainga..");
        course.setUser(user);
        courseDao.save(course);
        
        // Create Lesson
        Lesson lesson = context.getBean(Lesson.class);
        lesson.setContentType(ContentType.PDF);
        lesson.setCourse(null);
        lesson.setCreatedAt(LocalDateTime.now());
        lesson.setOrderIndex(5);
        lesson.setTitle("sample_lesson");
        lesson.setVideoUrl("");
        lesson.setCourse(course);
        lessonDao.save(lesson);
        
        // Create Quiz
        Quiz quiz = context.getBean(Quiz.class);
        quiz.setTitle("OOP Concepts Quiz");
        quiz.setCreatedAt(LocalDateTime.now());
        quiz.setLesson(lesson);
        quizDao.save(quiz);

        // Create QuizAttempt
        QuizAttempt attempt = context.getBean(QuizAttempt.class);
        attempt.setUser(user);
        attempt.setQuiz(quiz);
        attempt.setScore(85);
        attempt.setAttemptedAt(LocalDateTime.now());
        quizAttemptDao.save(attempt);

        System.out.println("Quiz Attempt saved:");
        System.out.println(quizAttemptDao.findById(attempt.getQuizAttemptId()).orElse(null));
    }
}
