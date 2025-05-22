package com.skillImprov.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "enrollment")
@Component
public class Enrollment {

	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "enrollmentId")
	    private Long enrollmentId;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "userId", nullable = false)
	    private User user;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "courseId", nullable = false)
	    private Course course;

	    @Column(name = "enrolled_at", nullable = false)
	    private LocalDateTime enrolledAt;

	    @Column(nullable = false)
	    private boolean completed = false;

	    // Constructors
	    public Enrollment() {}

	    public Long getEnrollmentId() {
			return enrollmentId;
		}

		public void setEnrollmentId(Long enrollmentId) {
			this.enrollmentId = enrollmentId;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public Course getCourse() {
			return course;
		}

		public void setCourse(Course course) {
			this.course = course;
		}

		public Enrollment(Long userId, Long courseId) {
	        this.user = user;
	        this.course = course;
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
			return "Enrollment [enrollmentId=" + enrollmentId + ", userId=" + user + ", courseId=" + course
					+ ", enrolledAt=" + enrolledAt + ", completed=" + completed + "]";
		}

	   
	

}
