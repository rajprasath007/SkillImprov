package com.skillImprov.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "enrollment")
@Component
public class Enrollment {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "enrollmentId")
	    private Long enrollmentId;

	    @Column(name = "enrolledAt", nullable = false)
	    private LocalDateTime enrolledAt;

	    @Column(nullable = false)
	    private boolean completed;
	    
	    @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "userId", nullable = false)
	    private User user;

	    @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "courseId", nullable = false)
	    private Course course;
	    
	    // Constructors
	    public Enrollment() {}
		
		public Enrollment(Long enrollmentId, LocalDateTime enrolledAt, boolean completed) {
			super();
			this.enrollmentId = enrollmentId;
			this.enrolledAt = enrolledAt;
			this.completed = completed;
		}

		public Enrollment(Long enrollmentId, Course course, LocalDateTime enrolledAt, boolean completed) {
			super();
			this.enrollmentId = enrollmentId;
			this.course = course;
			this.enrolledAt = enrolledAt;
			this.completed = completed;
		}

		public Enrollment(Long userId, Long courseId, User user, Course course) {
	        this.user = user;
	        this.course = course;
	        this.enrolledAt = LocalDateTime.now();
	        this.completed = false;
	    }

	    // Getters and Setters
		
	    public Long getEnrollmentId() {
			return enrollmentId;
		}
		
		public void setEnrollmentId(Long enrollmentId) {
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

		@Override
		public String toString() {
			return "Enrollment [enrollmentId=" + enrollmentId + ", userId=" + user + ", courseId=" + course
					+ ", enrolledAt=" + enrolledAt + ", completed=" + completed + "]";
		}

	   
	

}
