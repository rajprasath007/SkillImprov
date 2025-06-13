package com.skillImprov.services;

import com.skillImprov.dao.interfaces.OptionDao;
import com.skillImprov.entity.Option;
import com.skillImprov.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OptionService {

    @Autowired
    private OptionDao optionDao;

    // Save or update option
    public Option save(Option option) {
        return optionDao.save(option);
    }

    // Find option by ID
    public Optional<Option> findById(Long id) {
        return optionDao.findById(id);
    }

    // Find all options
    public List<Option> findAll() {
        return optionDao.findAll();
    }

    // Delete option by ID
    public void deleteById(Long id) {
        optionDao.deleteById(id);
    }

    // Delete an option entity
    public void delete(Option option) {
        optionDao.delete(option);
    }

    // Check if option exists by ID
    public boolean existsById(Long id) {
        return optionDao.existsById(id);
    }

    // Count total options
    public long count() {
        return optionDao.count();
    }

    // Find options by question
    public List<Option> findByQuestion(Question question) {
        return optionDao.findByQuestion(question);
    }
}
