package com.skillImprov.entity;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.skillImprov.enums.NotificationType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "notification")
@Component
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notificationId;

    @Column(name = "message", nullable = false, columnDefinition = "TEXT")
    private String message;

    @Column(name = "seen", nullable = false)
    private Boolean seen;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private NotificationType type;

    @Column(name = "createdAt", nullable = false)
    private LocalDateTime createdAt;
    
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    public Notification(Long id,String message, Boolean seen, NotificationType type,
			LocalDateTime createdAt) {
		super();
		this.notificationId = id;
		this.message = message;
		this.seen = seen;
		this.type = type;
		this.createdAt = createdAt;
	}
    
	public Notification() {
		super();
	}
	
	public Notification(User user, String message, Boolean seen, NotificationType type, LocalDateTime createdAt) {
		super();
		this.user = user;
		this.message = message;
		this.seen = seen;
		this.type = type;
		this.createdAt = createdAt;
	}
	
	// Getters and Setters
    public Long getNotificationId() { 
    	return notificationId; 
    }
    
    public void setNotificationId(Long id) { 
    	this.notificationId = id; 
    }

    public User getUser() { 
    	return user;
    }
    
    public void setUser(User user) { 
    	this.user = user; 
    }

    public String getMessage() { 
    	return message; 
    }
    
    public void setMessage(String message) { 
    	this.message = message; 
    }

    public Boolean getSeen() { 
    	return seen; 
    }
    
    public void setSeen(Boolean seen) { 
    	this.seen = seen; 
    }

    public NotificationType getType() { 
    	return type; 
    }
    
    public void setType(NotificationType type) { 
    	this.type = type; 
    }

    public LocalDateTime getCreatedAt() { 
    	return createdAt; 
    }
    
    public void setCreatedAt(LocalDateTime createdAt) { 
    	this.createdAt = createdAt; 
    }
    
    @Override
	public String toString() {
		return "Notification [id=" + notificationId + ", user=" + user + ", message=" + message + ", seen=" + seen + ", type="
				+ type + ", createdAt=" + createdAt + "]";
	}
}

