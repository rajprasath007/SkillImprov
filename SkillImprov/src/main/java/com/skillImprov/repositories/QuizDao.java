package com.skillImprov.repositories;

import com.skillImprov.entity.Quiz;
import com.skillImprov.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizDao extends JpaRepository<Quiz, Long> {
    List<Quiz> findByLesson(Lesson lesson);
}
