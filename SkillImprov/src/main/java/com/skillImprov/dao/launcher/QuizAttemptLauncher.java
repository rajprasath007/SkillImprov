package com.skillImprov.dao.launcher;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.skillImprov.config.BeanConfig;
import com.skillImprov.entity.Course;
import com.skillImprov.entity.Quiz;
import com.skillImprov.entity.QuizAttempt;
import com.skillImprov.entity.User;
import com.skillImprov.enums.DifficultyLevel;
import com.skillImprov.enums.VideoStatus;

public class QuizAttemptLauncher {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(BeanConfig.class);
		Session session = (Session) ac.getBean("hibSession");

		QuizAttempt attempt = new QuizAttempt(); // ✅ Correct way

		Quiz quiz = session.get(Quiz.class, 2L);
		User user = session.get(User.class, 1L);

		if (user != null && quiz != null) {
		    Transaction tx = session.beginTransaction();

		    attempt.setUser(user);
		    attempt.setQuiz(quiz);
		    attempt.setScore(85);
		    attempt.setAttemptedAt(LocalDateTime.now());

		    session.persist(attempt);
		    tx.commit();
		    System.out.println("QuizAttempt saved successfully.");
		} else {
		    System.out.println("User or quiz not found.");
		}

		try {
            session.beginTransaction();

            List<QuizAttempt> quizAttempts= session.createQuery("from QuizAttempt",QuizAttempt.class).list();

            for (QuizAttempt quizattempt :quizAttempts ) {
                System.out.println(quizattempt);
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
	            Long id = 1L; // set the ID you want to fetch
	            QuizAttempt enrollment13 = session.get(QuizAttempt.class, id);

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
	            QuizAttempt  enr = session.get(QuizAttempt.class, id);

	            if (enr != null) {
	                // Step 5: Update fields
	                
	            	attempt.setScore(85);
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
	            QuizAttempt  enrollment4 = session.get(QuizAttempt.class, enrollmentId);
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
