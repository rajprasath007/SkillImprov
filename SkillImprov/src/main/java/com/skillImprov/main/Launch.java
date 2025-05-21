package com.skillImprov.main;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.skillImprov.config.BeanConfig;
import com.skillImprov.entity.User;
@SpringBootApplication
public class Launch {
     public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(BeanConfig.class);
		//User user =(User)(ac.getBean("user"));
		Session session=new Configuration().configure().addAnnotatedClass(User.class).buildSessionFactory().openSession();
		User user = session.get(User.class, 202); 
		session.beginTransaction();
		session.remove(user);
		session.getTransaction().commit();
		
		System.out.print("Data removed");
		//System.out.println(session.get(User.class, 1));
		ac.close();
	}
}
