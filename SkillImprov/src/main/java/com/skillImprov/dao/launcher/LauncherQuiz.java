package com.skillImprov.dao.launcher;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.skillImprov.config.BeanConfig;
import com.skillImprov.entity.Lesson;
import com.skillImprov.entity.Quiz;

public class LauncherQuiz {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(BeanConfig.class);
		 Quiz en =(Quiz)(ac.getBean("quiz"));
		
		Session session= (Session) ac.getBean("hibSession");
		Lesson lesson = session.get(Lesson.class,1L); 
		 
	    
	    Transaction tx = session.beginTransaction();

	  
	    System.out.println(lesson);
	  
		if (lesson != null) {
		    en.setLesson(lesson);  // Foreign key
		    en.setTitle("Quiz on Spring Boot Basics");
		    en.setCreatedAt(LocalDateTime.now());  
		    session.persist(en);
	        tx.commit();
		    System.out.println("Progress saved successfully.");
		} else {
		    System.out.println("User or Lesson not found.");
		    tx.rollback();
		
		}
		try {
       session.beginTransaction();

       List<Quiz> progress = session.createQuery("from Quiz",Quiz.class).list();

       for (Quiz q : progress) {
           System.out.println(q);
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
       Quiz progress1 = session.get(Quiz.class, id);

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
       Quiz progress2 = session.get(Quiz.class, id);

       if (progress2 != null) {
           // Step 5: Update fields
           
           progress2.setTitle("python");
         
          

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
       Quiz  Progress4 = session.get(Quiz.class, ProgressId);
       if (Progress4 != null) {
           session.remove(Progress4);
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

