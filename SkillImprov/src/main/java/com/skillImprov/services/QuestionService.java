package com.skillImprov.services;

import com.skillImprov.dao.interfaces.QuestionDao;
import com.skillImprov.entity.Question;
import com.skillImprov.entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionDao questionDao;

    // Save or update a Question
    public Question save(Question question) {
        return questionDao.save(question);
    }

    // Find Question by ID
    public Optional<Question> findById(Long id) {
        return questionDao.findById(id);
    }

    // Find all Questions
    public List<Question> findAll() {
        return questionDao.findAll();
    }

    // Delete Question by ID
    public void deleteById(Long id) {
        questionDao.deleteById(id);
    }

    // Delete a Question entity
    public void delete(Question question) {
        questionDao.delete(question);
    }

    // Check existence by ID
    public boolean existsById(Long id) {
        return questionDao.existsById(id);
    }

    // Count total Questions
    public long count() {
        return questionDao.count();
    }

    // Find all Questions by Quiz
    public List<Question> findByQuiz(Quiz quiz) {
        return questionDao.findByQuiz(quiz);
    }
}
