package com.skillImprov.main;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.skillImprov.config.BeanConfig;
import com.skillImprov.entity.Course;
import com.skillImprov.entity.Lesson;
import com.skillImprov.entity.User;
import com.skillImprov.enums.DifficultyLevel;
import com.skillImprov.enums.VideoStatus;
@SpringBootApplication
public class Launch {
     public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(BeanConfig.class);
		Course en =(Course)(ac.getBean("course"));
		
		Session session=new Configuration().configure().addAnnotatedClass(User.class).addAnnotatedClass(Course.class).buildSessionFactory().openSession();
	 
		           
		
		
        
		
     }
}
