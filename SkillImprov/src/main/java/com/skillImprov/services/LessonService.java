package com.skillImprov.services;

import com.skillImprov.entity.Lesson;
import com.skillImprov.repositories.LessonDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LessonService {

    @Autowired
    private LessonDao lessonDao;

    // Save or update lesson
    public Lesson save(Lesson lesson) {
        return lessonDao.save(lesson);
    }

    // Find lesson by ID
    public Optional<Lesson> findById(Long id) {
        return lessonDao.findById(id);
    }

    // Find all lessons
    public List<Lesson> findAll() {
        return lessonDao.findAll();
    }

    // Delete lesson by ID
    public void deleteById(Long id) {
        lessonDao.deleteById(id);
    }

    // Delete a lesson entity
    public void delete(Lesson lesson) {
        lessonDao.delete(lesson);
    }

    // Check if lesson exists by ID
    public boolean existsById(Long id) {
        return lessonDao.existsById(id);
    }

    // Count total lessons
    public long count() {
        return lessonDao.count();
    }

    // Custom method: Find lessons by Course ID
    public List<Lesson> findByCourseId(Long courseId) {
        return lessonDao.findByCourse_CourseId(courseId);
    }
}
