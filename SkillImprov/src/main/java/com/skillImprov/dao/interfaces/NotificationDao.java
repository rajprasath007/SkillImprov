package com.skillImprov.dao.interfaces;

import com.skillImprov.entity.Notification;
import com.skillImprov.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationDao extends JpaRepository<Notification, Long> {
    List<Notification> findByUser(User user);
    List<Notification> findByUserAndSeen(User user, Boolean seen);
}
