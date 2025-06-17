package com.skillImprov.repositories;

import com.skillImprov.entity.Question;
import com.skillImprov.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Long> {
    List<Question> findByQuiz(Quiz quiz);
}
