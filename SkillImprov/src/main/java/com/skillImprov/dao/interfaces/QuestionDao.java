package com.skillImprov.dao.interfaces;

import com.skillImprov.entity.Question;
import com.skillImprov.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionDao extends JpaRepository<Question, Long> {
    List<Question> findByQuiz(Quiz quiz);
}
