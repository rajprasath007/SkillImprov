package com.skillImprov.dao.interfaces;

import com.skillImprov.entity.Quiz;
import com.skillImprov.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizDao extends JpaRepository<Quiz, Long> {
    List<Quiz> findByLesson(Lesson lesson);
}
