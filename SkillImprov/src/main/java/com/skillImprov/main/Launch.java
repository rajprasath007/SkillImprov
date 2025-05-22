package com.skillImprov.main;


import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.skillImprov.config.BeanConfig;
import com.skillImprov.entity.Course;
import com.skillImprov.entity.User;
@SpringBootApplication
public class Launch {
     public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(BeanConfig.class);
//		Course en =(Course)(ac.getBean("course"));
		
		Session session=new Configuration().configure().addAnnotatedClass(User.class).addAnnotatedClass(Course.class).buildSessionFactory().openSession();
		
		
		session.close();
		ac.close();
		
     }
}
