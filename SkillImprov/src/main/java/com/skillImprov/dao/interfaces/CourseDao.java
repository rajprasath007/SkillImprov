package com.skillImprov.dao.interfaces;

import com.skillImprov.entity.Course;
import com.skillImprov.entity.User;
import com.skillImprov.enums.VideoStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseDao extends JpaRepository<Course, Long> {
    List<Course> findByUser(User user);
    List<Course> findByStatus(VideoStatus status);
    List<Course> findByCategory(String category);
}
