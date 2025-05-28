package com.skillImprov.dao.launcher;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.skillImprov.config.BeanConfig;
import com.skillImprov.entity.Course;
import com.skillImprov.entity.Option;
import com.skillImprov.entity.Question;
import com.skillImprov.entity.Quiz;
import com.skillImprov.enums.QuestionType;

public class LauncherOption {
public static void main(String[] args) {
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(BeanConfig.class);
	Option en =(Option)(ac.getBean("option"));
	
	
    
	Session session = (Session) ac.getBean("hibSession");

	try {
	    Transaction tx = session.beginTransaction();

	    Question question = session.get(Question.class, 2L);
	    if (question != null) {
	        Option option1 = new Option();
	        option1.setQuestion(question);
	        option1.setOptionText("Spring Boot is a backend framework.");
	        option1.setIsCorrect(true);

	        Option option2 = new Option();
	        option2.setQuestion(question);
	        option2.setOptionText("Spring Boot is a frontend library.");
	        option2.setIsCorrect(false);

	        session.persist(option1);
	        session.persist(option2);

	        tx.commit();
	        System.out.println("Options saved successfully.");
	    } else {
	        System.out.println("Question not found.");
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	} 
	 session.beginTransaction();
    List<Option> questions = session.createQuery("from Option", Option.class).list();
         for (Option q : questions) {
             System.out.println(q);
         }
         session.getTransaction().commit();

         // Fetch question by ID
         session.beginTransaction();
         Option q2 = session.get(Option.class, 2L);
         System.out.println(q2 != null ? "Option found: " + q2 : "Option not found.");
         session.getTransaction().commit();

         // Update question
         session.beginTransaction();
         Option q3 = session.get(Option.class, 2L);
         if (q3 != null) {
             q3.setOptionText("Spring Boot and Java for Beginners");
         } else {
             System.out.println("Question not found.");
         }
         session.getTransaction().commit();
         System.out.println("option updated successfully.");

         // Delete question
         session.beginTransaction();
         Option qToDelete = session.get(Option.class, 1L);
         if (qToDelete != null) {
             session.remove(qToDelete);
             System.out.println("option deleted successfully.");
         } else {
             System.out.println("option not found for deletion.");
         }
         session.getTransaction().commit();

     }


}
