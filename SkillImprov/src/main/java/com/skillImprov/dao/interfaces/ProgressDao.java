package com.skillImprov.dao.interfaces;

import com.skillImprov.entity.Progress;
import com.skillImprov.entity.User;
import com.skillImprov.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgressDao extends JpaRepository<Progress, Long> {
    List<Progress> findByUser(User user);
    List<Progress> findByLesson(Lesson lesson);
}
