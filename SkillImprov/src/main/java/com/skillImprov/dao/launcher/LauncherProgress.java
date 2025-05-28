package com.skillImprov.dao.launcher;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.skillImprov.config.BeanConfig;
import com.skillImprov.entity.Lesson;
import com.skillImprov.entity.Progress;
import com.skillImprov.entity.User;

public class LauncherProgress {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(BeanConfig.class);
		Progress progress =(Progress)(ac.getBean("progress"));
		
		Session session = (Session) ac.getBean("hibSession");
		Lesson lesson = session.get(Lesson.class,1L); 
		User user = session.get(User.class,1L); 
	    
	    Transaction tx = session.beginTransaction();

	    System.out.println(user);
	    System.out.println(lesson);
	  
		if (user != null || lesson != null) {
		    progress.setUser(user);
		    progress.setLesson(lesson);
		    progress.setProgress(new BigDecimal("76.50"));
		    progress.setUpdatedAt(LocalDateTime.now());

		    // Save to database
		    session.persist(progress);

		   
	        session.persist(lesson);
	        tx.commit();
		    System.out.println("Progress saved successfully.");
		} else {
		    System.out.println("User or Lesson not found.");
		    tx.rollback();

		
		}
		try {
            session.beginTransaction();

            List<Progress> progres = session.createQuery("from Progress",Progress.class).list();

            for (Progress prog : progres) {
                System.out.println(prog);
            }

            session.getTransaction().commit();
        }catch(Exception e) {
        	e.printStackTrace();
        }

        System.out.println("sucessfully: " );
        try {
            // Step 3: Begin transaction
            session.beginTransaction();

            // Step 4: Fetch the lesson by ID
            Long id = 2L; // set the ID you want to fetch
            Progress progress1 = session.get(Progress.class, id);

            if (progress1 != null) {
                System.out.println("Lesson found: " + progress1);
            } else {
                System.out.println("Lesson not found.");
            }

            // Step 5: Commit transaction
            session.getTransaction().commit();
        } catch(Exception e) {
        	e.printStackTrace();
        }  try {
            // Step 3: Begin transaction
            session.beginTransaction();

            // Step 4: Get the lesson by ID
            Long id = 1L;
            Progress progress2 = session.get(Progress.class, id);

            if (progress2 != null) {
                // Step 5: Update fields
                
                progress2.setProgress(new BigDecimal("56.70"));
              
               

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
            Long ProgressId = 1L; // Change this to the ID you want to delete

            session.beginTransaction();

            // Option 1: Retrieve and delete the object
            Progress  Progress4 = session.get(Progress.class, ProgressId);
            if (Progress4 != null) {
                session.remove(Progress4);
                System.out.println("User deleted successfully.");
            } else {
                System.out.println("User not found.");
            }

            session.getTransaction().commit();
        } finally {
            session.close();
           ac.close();
        }
	}   
}
