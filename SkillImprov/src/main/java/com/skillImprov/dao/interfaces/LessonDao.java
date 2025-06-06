package com.skillImprov.dao.interfaces;

import com.skillImprov.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LessonDao extends JpaRepository<Lesson, Long> {
    List<Lesson> findByCourse_CourseId(Long courseId);
}
