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
	            .addAnnotatedClass(Notification.class)// ✅ Add Option entity here
	            .buildSessionFactory()
	            .openSession();
	}

    
   

   
    
}
