package com.skillImprov.services;

import com.skillImprov.entity.Quiz;
import com.skillImprov.repositories.QuizDao;
import com.skillImprov.entity.Lesson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuizDao quizDao;

    public Quiz save(Quiz quiz) {
        return quizDao.save(quiz);
    }

    public Optional<Quiz> findById(Long id) {
        return quizDao.findById(id);
    }

    public List<Quiz> findAll() {
        return quizDao.findAll();
    }

    public void deleteById(Long id) {
        quizDao.deleteById(id);
    }

    public void delete(Quiz quiz) {
        quizDao.delete(quiz);
    }

    public boolean existsById(Long id) {
        return quizDao.existsById(id);
    }

    public long count() {
        return quizDao.count();
    }

    public List<Quiz> findByLesson(Lesson lesson) {
        return quizDao.findByLesson(lesson);
    }
}
