package com.skillImprov.config;

import org.hibernate.Session;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import com.skillImprov.entity.Course;
import com.skillImprov.entity.Enrollment;
import com.skillImprov.entity.Lesson;
import com.skillImprov.entity.Notification;
import com.skillImprov.entity.Option;
import com.skillImprov.entity.Progress;
import com.skillImprov.entity.Question;
import com.skillImprov.entity.Quiz;
import com.skillImprov.entity.QuizAttempt;
import com.skillImprov.entity.User;

@EnableWebSecurity
@SpringBootConfiguration
@ComponentScan(basePackages = "com.skillImprov.entity")
public class BeanConfig {

    @Bean
    public Session hibSession() {
        return new org.hibernate.cfg.Configuration()
                .configure()
                .addAnnotatedClass(Question.class)
                .addAnnotatedClass(Lesson.class)
                .addAnnotatedClass(Quiz.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Enrollment.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Progress.class)
                .addAnnotatedClass(Option.class)
                .addAnnotatedClass(QuizAttempt.class)
                .addAnnotatedClass(Notification.class)
                .buildSessionFactory()
                .openSession();
    }

    @Bean
    public Course course() {
        return new Course();
    }

    @Bean
    public Enrollment enrollment() {
        return new Enrollment();
    }

    @Bean
    public Lesson lesson() {
        return new Lesson();
    }

    @Bean
    public Notification notification() {
        return new Notification();
    }

    @Bean
    public Option option() {
        return new Option();
    }

    @Bean
    public Progress progress() {
        return new Progress();
    }

    @Bean
    public Question question() {
        return new Question();
    }

    @Bean
    public Quiz quiz() {
        return new Quiz();
    }

    @Bean
    public QuizAttempt quizAttempt() {
        return new QuizAttempt();
    }

    @Bean
    public User user() {
        return new User();
    }
}
