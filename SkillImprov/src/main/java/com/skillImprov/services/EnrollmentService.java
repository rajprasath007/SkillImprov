package com.skillImprov.services;

import com.skillImprov.entity.Enrollment;
import com.skillImprov.repositories.EnrollmentDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentDao enrollmentDao;

    // Save or update enrollment
    public Enrollment save(Enrollment enrollment) {
        return enrollmentDao.save(enrollment);
    }

    // Find enrollment by ID
    public Optional<Enrollment> findById(Long id) {
        return enrollmentDao.findById(id);
    }

    // Find all enrollments
    public List<Enrollment> findAll() {
        return enrollmentDao.findAll();
    }

    // Delete enrollment by ID
    public void deleteById(Long id) {
        enrollmentDao.deleteById(id);
    }

    // Delete an enrollment entity
    public void delete(Enrollment enrollment) {
        enrollmentDao.delete(enrollment);
    }

    // Check if enrollment exists by ID
    public boolean existsById(Long id) {
        return enrollmentDao.existsById(id);
    }

    // Count total enrollments
    public long count() {
        return enrollmentDao.count();
    }

    // Find enrollments by user ID
    public List<Enrollment> findByUserId(Long userId) {
        return enrollmentDao.findByUserUserId(userId);
    }

    // Find enrollments by course ID
    public List<Enrollment> findByCourseId(Long courseId) {
        return enrollmentDao.findByCourseCourseId(courseId);
    }

    // Check if a user is already enrolled in a course
    public boolean existsByUserIdAndCourseId(Long userId, Long courseId) {
        return enrollmentDao.existsByUserUserIdAndCourseCourseId(userId, courseId);
    }
}
