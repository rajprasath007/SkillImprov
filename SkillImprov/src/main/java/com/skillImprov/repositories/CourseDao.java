package com.skillImprov.repositories;

import com.skillImprov.entity.Course;
import com.skillImprov.entity.User;
import com.skillImprov.enums.VideoStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseDao extends JpaRepository<Course, Long> {
    List<Course> findByUser(User user);
    List<Course> findByStatus(VideoStatus status);
    List<Course> findByCategory(String category);
}
