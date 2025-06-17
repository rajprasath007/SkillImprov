package com.skillImprov.services;

import com.skillImprov.entity.Notification;
import com.skillImprov.entity.User;
import com.skillImprov.repositories.NotificationDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    @Autowired
    private NotificationDao notificationDao;

    // Save or update notification
    public Notification save(Notification notification) {
        return notificationDao.save(notification);
    }

    // Find notification by ID
    public Optional<Notification> findById(Long id) {
        return notificationDao.findById(id);
    }

    // Find all notifications
    public List<Notification> findAll() {
        return notificationDao.findAll();
    }

    // Delete notification by ID
    public void deleteById(Long id) {
        notificationDao.deleteById(id);
    }

    // Delete a notification entity
    public void delete(Notification notification) {
        notificationDao.delete(notification);
    }

    // Check if notification exists by ID
    public boolean existsById(Long id) {
        return notificationDao.existsById(id);
    }

    // Count total notifications
    public long count() {
        return notificationDao.count();
    }

    // Find notifications by user
    public List<Notification> findByUser(User user) {
        return notificationDao.findByUser(user);
    }

    // Find notifications by user and seen status
    public List<Notification> findByUserAndSeen(User user, Boolean seen) {
        return notificationDao.findByUserAndSeen(user, seen);
    }
}
