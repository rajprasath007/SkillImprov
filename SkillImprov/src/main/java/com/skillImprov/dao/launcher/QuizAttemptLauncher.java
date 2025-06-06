package com.skillImprov.dao.launcher;

import com.skillImprov.dao.interfaces.QuizAttemptDao;
import com.skillImprov.dao.interfaces.QuizDao;
import com.skillImprov.dao.interfaces.UserDao;
import com.skillImprov.entity.Quiz;
import com.skillImprov.entity.QuizAttempt;
import com.skillImprov.entity.User;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDateTime;

@SpringBootApplication(scanBasePackages = "com.skillImprov")
@EnableJpaRepositories(basePackages = "com.skillImprov.dao.interfaces")
@EntityScan(basePackages = "com.skillImprov.entity")
public class QuizAttemptLauncher {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(QuizAttemptLauncher.class, args);

        UserDao userDao = context.getBean(UserDao.class);
        QuizDao quizDao = context.getBean(QuizDao.class);
        QuizAttemptDao quizAttemptDao = context.getBean(QuizAttemptDao.class);

        // Create User
        User user = context.getBean(User.class);
        user.setUsername("quiz_user");
        user.setEmail("quiz_user@example.com");
        user.setPassword("password");
        user.setCreatedAt(LocalDateTime.now());
        userDao.save(user);

        // Create Quiz
        Quiz quiz = context.getBean(Quiz.class);
        quiz.setTitle("OOP Concepts Quiz");
        quiz.setCreatedAt(LocalDateTime.now());
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
