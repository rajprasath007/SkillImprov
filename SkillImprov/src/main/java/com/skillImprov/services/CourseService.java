package com.skillImprov.services;

import com.skillImprov.dao.interfaces.CourseDao;
import com.skillImprov.entity.Course;
import com.skillImprov.entity.User;
import com.skillImprov.enums.VideoStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseDao courseDao;

    // Save or update course
    public Course save(Course course) {
        return courseDao.save(course);
    }

    // Find course by ID
    public Optional<Course> findById(Long id) {
        return courseDao.findById(id);
    }

    // Find all courses
    public List<Course> findAll() {
        return courseDao.findAll();
    }

    // Delete course by ID
    public void deleteById(Long id) {
        courseDao.deleteById(id);
    }

    // Delete a course entity
    public void delete(Course course) {
        courseDao.delete(course);
    }

    // Check if course exists by ID
    public boolean existsById(Long id) {
        return courseDao.existsById(id);
    }

    // Count total courses
    public long count() {
        return courseDao.count();
    }

    // Find courses by instructor
    public List<Course> findByUser(User user) {
        return courseDao.findByUser(user);
    }

    // Find courses by status (published, draft, etc.)
    public List<Course> findByStatus(VideoStatus status) {
        return courseDao.findByStatus(status);
    }

    // Find courses by category
    public List<Course> findByCategory(String category) {
        return courseDao.findByCategory(category);
    }
}
