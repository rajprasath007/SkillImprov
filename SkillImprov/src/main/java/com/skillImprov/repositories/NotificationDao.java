package com.skillImprov.repositories;

import com.skillImprov.entity.Notification;
import com.skillImprov.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationDao extends JpaRepository<Notification, Long> {
    List<Notification> findByUser(User user);
    List<Notification> findByUserAndSeen(User user, Boolean seen);
}
