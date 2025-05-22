package com.skillImprov.dao.launcher;

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
import com.skillImprov.enums.ContentType;
public class LessonLauncher {
	 public static void main(String[] args) {
			AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(BeanConfig.class);
			Lesson en =(Lesson)(ac.getBean("lesson"));
			
			Session session=new Configuration().configure().addAnnotatedClass(Lesson.class).addAnnotatedClass(Course.class).buildSessionFactory().openSession();
			Course course = session.get(Course.class,1L);    
		    
			Lesson lesson=new Lesson();
			lesson.setTitle("Introduction to Java");
			lesson.setVideoUrl("https://example.com/video1.mp4");
			lesson.setOrderIndex(1);
			lesson.setContentType(ContentType.VIDEO); // assuming ContentType is an enum
			lesson.setCreatedAt(LocalDateTime.now());

			lesson.setCourse(course);
		
			
			
	        // Save to database
	        Transaction tx = session.beginTransaction();
	        session.persist(lesson);
	        tx.commit();
	        try {
	            session.beginTransaction();

	            List<Lesson> users = session.createQuery("from Lesson", Lesson.class).list();

	            for (Lesson user : users) {
	                System.out.println(user);
	            }

	            session.getTransaction().commit();
	        }catch(Exception e) {
	        	e.printStackTrace();
	        }

	        System.out.println("Enrollment inserted: " );
	        try {
	            // Step 3: Begin transaction
	            session.beginTransaction();

	            // Step 4: Fetch the lesson by ID
	            Long id = 2L; // set the ID you want to fetch
	            Lesson lesson1 = session.get(Lesson.class, id);

	            if (lesson != null) {
	                System.out.println("Lesson found: " + lesson1);
	            } else {
	                System.out.println("Lesson not found.");
	            }

	            // Step 5: Commit transaction
	            session.getTransaction().commit();
	        } catch(Exception e) {
	        	e.printStackTrace();
	        }
	        try {
	            // Step 3: Begin transaction
	            session.beginTransaction();

	            // Step 4: Get the lesson by ID
	            Long id = 1L;
	            Lesson lesson2 = session.get(Lesson.class, id);

	            if (lesson2 != null) {
	                // Step 5: Update fields
	                lesson2.setTitle("Updated Java Basics");
	                lesson2.setVideoUrl("This is an updated lesson description.");
	                lesson2.setOrderIndex(7);
	                lesson2.setContentType(ContentType.PDF);
	               

	                // Step 6: Hibernate automatically tracks changes (dirty checking)
	            } else {
	                System.out.println("Lesson not found");
	            }

	            // Step 7: Commit transaction
	            session.getTransaction().commit();

	            System.out.println("Lesson updated successfully.");
	        } catch(Exception e) {
	        	e.printStackTrace();
	        }
	        try {
	            Long userId = 1L; // Change this to the ID you want to delete

	            session.beginTransaction();

	            // Option 1: Retrieve and delete the object
	            Lesson  lesson4 = session.get(Lesson.class, userId);
	            if (lesson4 != null) {
	                session.remove(lesson4);
	                System.out.println("User deleted successfully.");
	            } else {
	                System.out.println("User not found.");
	            }

	            session.getTransaction().commit();
	        } finally {
	            session.close();
	           
	        }
	        
			
	     }

}
