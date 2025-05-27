package com.skillImprov.config;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration; // ✅ Hibernate Configuration

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.skillImprov.entity.Course;
import com.skillImprov.entity.Enrollment;
import com.skillImprov.entity.Lesson;
import com.skillImprov.entity.Progress;
import com.skillImprov.entity.Question;
import com.skillImprov.entity.Quiz;

import com.skillImprov.entity.User;

@SpringBootConfiguration
@ComponentScan(basePackages = "com.skillImprov.entity")
public class BeanConfig {

<<<<<<< HEAD
	  @Bean
	    public Session hibSession() {
	    	 return new org.hibernate.cfg.Configuration()
	                 .configure().addAnnotatedClass(Question.class)
	                 .addAnnotatedClass(Lesson.class).addAnnotatedClass(Quiz.class).addAnnotatedClass(User.class).addAnnotatedClass(Enrollment.class).addAnnotatedClass(Course.class).addAnnotatedClass(Progress.class)
	                 .buildSessionFactory().openSession();
	    }
=======
    @Bean
    public Session hibSession() {
        return new org.hibernate.cfg.Configuration().configure().addAnnotatedClass(Lesson.class).addAnnotatedClass(User.class).addAnnotatedClass(Quiz.class).addAnnotatedClass(Enrollment.class).addAnnotatedClass(Course.class).addAnnotatedClass(Progress.class).buildSessionFactory().openSession();
    }
    
    @Bean
    public Quiz quiz() {
    	return new Quiz();
    }
    
>>>>>>> branch 'main' of https://github.com/rajprasath007/SkillImprov.git
}
