package com.skillImprov.dao.interfaces;

import com.skillImprov.entity.QuizAttempt;
import com.skillImprov.entity.User;
import com.skillImprov.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizAttemptDao extends JpaRepository<QuizAttempt, Long> {
    List<QuizAttempt> findByUser(User user);
    List<QuizAttempt> findByQuiz(Quiz quiz);
}
