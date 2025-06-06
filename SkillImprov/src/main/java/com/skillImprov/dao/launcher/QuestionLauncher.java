package com.skillImprov.dao.launcher;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.skillImprov.config.BeanConfig;
import com.skillImprov.entity.Question;
import com.skillImprov.entity.Quiz;
import com.skillImprov.enums.QuestionType;

public class QuestionLauncher {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(BeanConfig.class);
        Question question = ac.getBean("question", Question.class);
        Session session = ac.getBean("hibSession", Session.class);

        try {
            Transaction tx = session.beginTransaction();

            Quiz quiz = session.get(Quiz.class, 2L);
            if (quiz != null) {
                question.setQuestionText("Spring Boot for Beginners");
                question.setQuestionType(QuestionType.MCQ);
                question.setQuiz(quiz);
                session.persist(question);
                tx.commit();
                System.out.println("Question saved successfully.");
            } else {
                System.out.println("Quiz not found.");
                tx.rollback();
            }

            // Fetch all questions
            session.beginTransaction();
            List<Question> questions = session.createQuery("from Question", Question.class).list();
            for (Question q : questions) {
                System.out.println(q);
            }
            session.getTransaction().commit();

            // Fetch question by ID
            session.beginTransaction();
            Question q2 = session.get(Question.class, 2L);
            System.out.println(q2 != null ? "Question found: " + q2 : "Question not found.");
            session.getTransaction().commit();

            // Update question
            session.beginTransaction();
            Question q3 = session.get(Question.class, 3L);
            if (q3 != null) {
                q3.setQuestionText("Spring Boot and Java for Beginners");
            } else {
                System.out.println("Question not found.");
            }
            session.getTransaction().commit();
            System.out.println("Question updated successfully.");

            // Delete question
            session.beginTransaction();
            Question qToDelete = session.get(Question.class, 1L);
            if (qToDelete != null) {
                session.remove(qToDelete);
                System.out.println("Question deleted successfully.");
            } else {
                System.out.println("Question not found for deletion.");
            }
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            ac.close();
        }
    }
}
