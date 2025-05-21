package com.skillImprov.main;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.skillImprov.config.BeanConfig;
import com.skillImprov.entity.Progres;
import com.skillImprov.entity.User;
@SpringBootApplication
public class Launch {
     public static void main(String[] args) {
		AnnotationConfigApplicationContext as=new AnnotationConfigApplicationContext(BeanConfig.class);
		User eu=(User)(as.getBean("user"));
		Session session=new Configuration().configure().addAnnotatedClass(User.class).buildSessionFactory().openSession();
		session.beginTransaction();
		session.save(eu);
		session.getTransaction().commit();
		
		System.out.print("Data inserted");
	}
}
