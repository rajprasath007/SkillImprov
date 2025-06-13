package com.skillImprov.services;

import com.skillImprov.dao.interfaces.ProgressDao;
import com.skillImprov.entity.Progress;
import com.skillImprov.entity.User;
import com.skillImprov.entity.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgressService {

    @Autowired
    private ProgressDao progressDao;

    // Save or update progress
    public Progress save(Progress progress) {
        return progressDao.save(progress);
    }

    // Find progress by ID
    public Optional<Progress> findById(Long id) {
        return progressDao.findById(id);
    }

    // Find all progress records
    public List<Progress> findAll() {
        return progressDao.findAll();
    }

    // Delete progress by ID
    public void deleteById(Long id) {
        progressDao.deleteById(id);
    }

    // Delete a progress entity
    public void delete(Progress progress) {
        progressDao.delete(progress);
    }

    // Check if progress exists by ID
    public boolean existsById(Long id) {
        return progressDao.existsById(id);
    }

    // Count total progress records
    public long count() {
        return progressDao.count();
    }

    // Find progress records by user
    public List<Progress> findByUser(User user) {
        return progressDao.findByUser(user);
    }

    // Find progress records by lesson
    public List<Progress> findByLesson(Lesson lesson) {
        return progressDao.findByLesson(lesson);
    }
}
