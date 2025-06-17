package com.skillImprov.services;

import com.skillImprov.entity.QuizAttempt;
import com.skillImprov.entity.User;
import com.skillImprov.repositories.QuizAttemptDao;
import com.skillImprov.entity.Quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizAttemptService {

    @Autowired
    private QuizAttemptDao quizAttemptDao;

    public QuizAttempt save(QuizAttempt quizAttempt) {
        return quizAttemptDao.save(quizAttempt);
    }

    public Optional<QuizAttempt> findById(Long id) {
        return quizAttemptDao.findById(id);
    }

    public List<QuizAttempt> findAll() {
        return quizAttemptDao.findAll();
    }

    public void deleteById(Long id) {
        quizAttemptDao.deleteById(id);
    }

    public void delete(QuizAttempt quizAttempt) {
        quizAttemptDao.delete(quizAttempt);
    }

    public boolean existsById(Long id) {
        return quizAttemptDao.existsById(id);
    }

    public long count() {
        return quizAttemptDao.count();
    }

    public List<QuizAttempt> findByUser(User user) {
        return quizAttemptDao.findByUser(user);
    }

    public List<QuizAttempt> findByQuiz(Quiz quiz) {
        return quizAttemptDao.findByQuiz(quiz);
    }
}
