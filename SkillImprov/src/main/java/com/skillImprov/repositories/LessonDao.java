package com.skillImprov.repositories;

import com.skillImprov.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonDao extends JpaRepository<Lesson, Long> {
    List<Lesson> findByCourse_CourseId(Long courseId);
}
