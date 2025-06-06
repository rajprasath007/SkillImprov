package com.skillImprov.dao.launcher;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.skillImprov.config.BeanConfig;
import com.skillImprov.entity.Course;
import com.skillImprov.entity.User;
import com.skillImprov.enums.DifficultyLevel;
import com.skillImprov.enums.VideoStatus;

public class CourseLauncher {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(BeanConfig.class);
		Course en =(Course)(ac.getBean("course"));
		
		
	    
		Session session = (Session) ac.getBean("hibSession");
		User user = session.get(User.class,1L); 
	    
	    Transaction tx = session.beginTransaction();

	    System.out.println(user);
	    
	  
		if (user != null) {
			
			en.setTitle("Spring Boot for Beginners");
			en.setDescription("Learn how to build REST APIs using Spring Boot.");
			en.setThumbnailUrl("https://example.com/springboot.jpg");
			en.setCategory("Backend Development");
			en.setStatus(VideoStatus.PUBLISHED);
			en.setUser(user);
		    // Save to database
		    

		   
	        session.persist(en);
	        tx.commit();
		    System.out.println("enrollment saved successfully.");
		} else {
		    System.out.println("User or course not found.");
		    tx.rollback();

		
		}
		try {
            session.beginTransaction();

            List<Course> courses= session.createQuery("from Course",Course.class).list();

            for (Course enrollment : courses) {
                System.out.println(enrollment);
            }

            session.getTransaction().commit();
        }catch(Exception e) {
        	e.printStackTrace();
        }
		System.out.println("suceesfully fetch: " );
		 try {
	            // Step 3: Begin transaction
	            session.beginTransaction();

	            // Step 4: Fetch the lesson by ID
	            Long id = 2L; // set the ID you want to fetch
	            Course enrollment13 = session.get(Course.class, id);

	            if (enrollment13 != null) {
	                System.out.println("enrollment found: " + enrollment13);
	            } else {
	                System.out.println("enrollment not found.");
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
	            Long id = 3L;
	            Course  enr = session.get(Course.class, id);

	            if (enr != null) {
	                // Step 5: Update fields
	                
	            	enr.setTitle("Java Programming");
	            	enr.setDescription("Deep dive into Java concurrency and streams.");
	            	enr.setThumbnailUrl("https://example.com/advanced-java.jpg");
	            	enr.setCategory("Java Development");
	            	enr.setStatus(VideoStatus.PUBLISHED);
	            	enr.setUser(user);  // Assuming 'user' is an existing User object

	              
	               

	                // Step 6: Hibernate automatically tracks changes (dirty checking)
	            } else {
	                System.out.println("Lesson not found");
	            }

	            // Step 7: Commit transaction
	            session.getTransaction().commit();

	            System.out.println("enrollment updated successfully.");
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		
		 try {
	            Long enrollmentId = 1L; // Change this to the ID you want to delete

	            session.beginTransaction();

	            // Option 1: Retrieve and delete the object
	            Course  enrollment4 = session.get(Course.class, enrollmentId);
	            if (enrollment4 != null) {
	                session.remove(enrollment4);
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
