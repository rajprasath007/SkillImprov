package com.skillImprov.repositories;

import com.skillImprov.entity.QuizAttempt;
import com.skillImprov.entity.User;
import com.skillImprov.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizAttemptDao extends JpaRepository<QuizAttempt, Long> {
    List<QuizAttempt> findByUser(User user);
    List<QuizAttempt> findByQuiz(Quiz quiz);
}
