package com.skillImprov.dao.launcher;

import com.skillImprov.dao.interfaces.QuizDao;
import com.skillImprov.dao.interfaces.LessonDao;
import com.skillImprov.entity.Quiz;
import com.skillImprov.enums.ContentType;
import com.skillImprov.entity.Lesson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDateTime;

@SpringBootApplication(scanBasePackages = "com.skillImprov")
@EnableJpaRepositories(basePackages = "com.skillImprov.dao.interfaces")
@EntityScan(basePackages = "com.skillImprov.entity")
public class QuizLauncher {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(QuizLauncher.class, args);

        LessonDao lessonDao = context.getBean(LessonDao.class);
        QuizDao quizDao = context.getBean(QuizDao.class);

        // Create Lesson
        Lesson lesson = context.getBean(Lesson.class);
        lesson.setTitle("Spring Boot Introduction");
        lesson.setContentType(ContentType.VIDEO);
        lesson.setCreatedAt(LocalDateTime.now());
        lessonDao.save(lesson);

        // Create Quiz
        Quiz quiz = context.getBean(Quiz.class);
        quiz.setLesson(lesson);
        quiz.setTitle("Spring Boot Basics Quiz");
        quiz.setCreatedAt(LocalDateTime.now());
        quizDao.save(quiz);

        System.out.println("Quiz saved:");
        System.out.println(quizDao.findById(quiz.getQuizId()).orElse(null));
    }
}
