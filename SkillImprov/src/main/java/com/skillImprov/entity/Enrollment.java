package com.skillImprov.entity;

import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="enrollment")
@Component
public class Enrollment {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	   
	    private Long enrollmentId;

	    @Column(name = "user_id", nullable = false)
	    private Long userId; // Or UUID if you're using UUID for User entity

	    @Column(name = "course_id", nullable = false)
	    private Long courseId; // Or UUID if you're using UUID for Course entity

	    @Column(name = "enrolled_at", nullable = false)
	    private LocalDateTime enrolledAt;

	    @Column(nullable = false)
	    private boolean completed = false;

	    // Constructors
	    public Enrollment() {}

	    public Enrollment(Long userId, Long courseId) {
	        this.userId = userId;
	        this.courseId = courseId;
	        this.enrolledAt = LocalDateTime.now();
	        this.completed = false;
	    }

	    // Getters and Setters

	    public Long getId() {
	        return enrollmentId;
	    }

	    public void setId(Long enrollmentId) {
	        this.enrollmentId = enrollmentId;
	    }

	    public Long getUserId() {
	        return userId;
	    }

	    public void setUserId(Long userId) {
	        this.userId = userId;
	    }

	    public Long getCourseId() {
	        return courseId;
	    }

	    public void setCourseId(Long courseId) {
	        this.courseId = courseId;
	    }

	    public LocalDateTime getEnrolledAt() {
	        return enrolledAt;
	    }

	    public void setEnrolledAt(LocalDateTime enrolledAt) {
	        this.enrolledAt = enrolledAt;
	    }

	    public boolean isCompleted() {
	        return completed;
	    }

	    public void setCompleted(boolean completed) {
	        this.completed = completed;
	    }

		@Override
		public String toString() {
			return "Enrollment [enrollmentId=" + enrollmentId + ", userId=" + userId + ", courseId=" + courseId
					+ ", enrolledAt=" + enrolledAt + ", completed=" + completed + "]";
		}

}
