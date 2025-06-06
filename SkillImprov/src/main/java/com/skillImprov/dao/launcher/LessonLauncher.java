package com.skillImprov.dao.launcher;


import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.skillImprov.config.BeanConfig;
import com.skillImprov.entity.Course;
import com.skillImprov.entity.Lesson;
import com.skillImprov.enums.ContentType;

public class LessonLauncher {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(BeanConfig.class);
        Lesson lesson = (Lesson) ac.getBean("lesson");
        Session session= (Session) ac.getBean("hibSession");

        // Get a course for foreign key reference
        Course course = session.get(Course.class, 3L); // Make sure course with ID 1 exists

        Transaction tx = session.beginTransaction();

        if (course != null) {
            lesson.setCourse(course);
            lesson.setTitle("Spring Boot Intro");
            lesson.setVideoUrl("https://example.com/video1");
            lesson.setOrderIndex(1);
            lesson.setContentType(ContentType.VIDEO);
            lesson.setCreatedAt(LocalDateTime.now());

            session.persist(lesson);
            tx.commit();
            System.out.println("Lesson saved successfully.");
        } else {
            System.out.println("Course not found.");
            tx.rollback();
        }

        // READ ALL
        try {
            session.beginTransaction();
            List<Lesson> lessons = session.createQuery("from Lesson", Lesson.class).list();
            for (Lesson l : lessons) {
                System.out.println(l);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // READ BY ID
        try {
        	session.beginTransaction();
            Long lessonId = 1L;
            Lesson foundLesson = session.get(Lesson.class, lessonId);
            if (foundLesson != null) {
                System.out.println("Lesson found: " + foundLesson);
            } else {
                System.out.println("Lesson not found.");
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // UPDATE
        try {
            session.beginTransaction();
            Long updateId = 1L;
            Lesson updateLesson = session.get(Lesson.class, updateId);
            if (updateLesson != null) {
                updateLesson.setTitle("Spring Boot Advanced");
                updateLesson.setOrderIndex(2);
                updateLesson.setVideoUrl("https://example.com/advanced");
                System.out.println("Lesson updated.");
            } else {
                System.out.println("Lesson not found for update.");
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // DELETE
        try {
            session.beginTransaction();
            Long deleteId = 2L;
            Lesson deleteLesson = session.get(Lesson.class, deleteId);
            if (deleteLesson != null) {
                session.remove(deleteLesson);
                System.out.println("Lesson deleted.");
            } else {
                System.out.println("Lesson not found for deletion.");
            }
            session.getTransaction().commit();
        } finally {
            session.close();
            ac.close();
        }
    }
}
