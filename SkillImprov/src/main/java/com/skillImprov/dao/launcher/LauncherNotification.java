package com.skillImprov.dao.launcher;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.skillImprov.config.BeanConfig;
import com.skillImprov.entity.Course;
import com.skillImprov.entity.Notification;
import com.skillImprov.entity.User;
import com.skillImprov.enums.DifficultyLevel;
import com.skillImprov.enums.NotificationType;
import com.skillImprov.enums.VideoStatus;

public class LauncherNotification {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(BeanConfig.class);
		Notification notification = (Notification) ac.getBean("notification");

		
		
	    
		Session session = (Session) ac.getBean("hibSession");
		User user = session.get(User.class,1L); 
	    
	    Transaction tx = session.beginTransaction();

	    System.out.println(user);
	    
	  
		if (user != null) {
			
			notification.setMessage("Your quiz result is available.");
		    notification.setSeen(false); // new notification
		    notification.setType(NotificationType.ALERT); // or INFO / REMINDER
		    notification.setCreatedAt(LocalDateTime.now());
			notification.setUser(user);
		    // Save to database
		    

		   
	        session.persist(notification);
	        tx.commit();
		    System.out.println("enrollment saved successfully.");
		} else {
		    System.out.println("User or course not found.");
		    tx.rollback();

		
		}
		try {
            session.beginTransaction();

            List<Notification> notifications= session.createQuery("from Notification",Notification.class).list();

            for (Notification notification1 : notifications) {
                System.out.println(notification1);
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
	            Notification enrollment13 = session.get(Notification.class, id);

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
	            Notification  enr = session.get(Notification.class, id);

	            if (enr != null) {
	                // Step 5: Update fields
	            	enr.setMessage("Your quiz result is unavailable.");
	    		    enr.setSeen(true); 
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
	            Notification  enrollment4 = session.get(Notification.class, enrollmentId);
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
