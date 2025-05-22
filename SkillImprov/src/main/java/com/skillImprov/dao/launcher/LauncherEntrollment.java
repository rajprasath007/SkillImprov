package com.skillImprov.dao.launcher;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.skillImprov.config.BeanConfig;
import com.skillImprov.entity.Course;
import com.skillImprov.entity.Enrollment;
import com.skillImprov.entity.User;

public class LauncherEntrollment {
	 public static void main(String[] args) {
			AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(BeanConfig.class);
			Enrollment enrollment =(Enrollment)(ac.getBean("enrollment"));
			
			Session session = new Configuration().configure().addAnnotatedClass(User.class)
					.addAnnotatedClass(Course.class).addAnnotatedClass(Enrollment.class)
					.buildSessionFactory().openSession();
			Course course = session.get(Course.class,1L); 
			User user = session.get(User.class,1L); 
		    
		    Transaction tx = session.beginTransaction();

		    System.out.println(user);
		    System.out.println(course);
		  
			if (user != null || course != null) {
				enrollment.setCourse(course);   // this is required
				enrollment.setUser(user);
				enrollment.setCompleted(false);
				enrollment.setEnrolledAt(LocalDateTime.now());

			    // Save to database
			    

			   
		        session.persist(enrollment);
		        tx.commit();
			    System.out.println("enrollment saved successfully.");
			} else {
			    System.out.println("User or course not found.");
			    tx.rollback();

			
			}
			try {
	            session.beginTransaction();

	            List<Enrollment> enrollment1 = session.createQuery("from Enrollment",Enrollment.class).list();

	            for (Enrollment en : enrollment1) {
	                System.out.println(en);
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
		            Enrollment enrollment13 = session.get(Enrollment.class, id);

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
		            Long id = 1L;
		            Enrollment  enrollment2 = session.get(Enrollment.class, id);

		            if (enrollment2 != null) {
		                // Step 5: Update fields
		                
		                enrollment2.setCompleted(true);
		              
		               

		                // Step 6: Hibernate automatically tracks changes (dirty checking)
		            } else {
		                System.out.println("Lesson not found");
		            }

		            // Step 7: Commit transaction
		            session.getTransaction().commit();

		            System.out.println("enrollment updated successfully.");
			 } catch(Exception e) {
		        	e.printStackTrace();
		     }
			 try {
		            Long enrollmentId = 1L; // Change this to the ID you want to delete

		            session.beginTransaction();

		            // Option 1: Retrieve and delete the object
		            Enrollment  enrollment4 = session.get(Enrollment.class, enrollmentId);
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
			ac.close();
	     }
	

}
