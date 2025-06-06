package com.skillImprov.dao.interfaces;

import com.skillImprov.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentDao extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByUserUserId(Long userId);
    List<Enrollment> findByCourseCourseId(Long courseId);
    boolean existsByUserUserIdAndCourseCourseId(Long userId, Long courseId);
}
