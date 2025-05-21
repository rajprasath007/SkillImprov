package com.skillImprov.entity;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;

import com.skillImprov.enums.DifficultyLevel;
import com.skillImprov.enums.VideoStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="course")
@Component
public class Course {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long courseId;

	    @Column(nullable = false, length = 200)
	    private String title;

	    @Column(columnDefinition = "TEXT")
	    private String description;

	    @Column(name = "thumbnail_url")
	    private String thumbnailUrl;

	    @Column(nullable = false, length = 100)
	    private String category;

	    @Enumerated(EnumType.STRING)
	    @Column(nullable = false, length = 20)
	    private DifficultyLevel level;

	    @Enumerated(EnumType.STRING)
	    @Column(nullable = false, length = 20)
	    private VideoStatus status;
        @CreationTimestamp
	    @Column(name = "created_at", nullable = false)
	    private LocalDateTime createdAt;

	    // Foreign Key Reference
	    @Column(name = "instructor_id", nullable = false)
	    private Long instructorId; // You can use UUID if your User entity uses UUID

	    // Constructors
	    public Course() {}
	    public Course(String title, String description, String thumbnailUrl, String category,DifficultyLevel level, VideoStatus status, Long instructorId) {
	    	this.title = title;
	    	this.description = description;
	    	this.thumbnailUrl = thumbnailUrl;
	    	this.category = category;
	    	this.level = level;
	    	this.status = status;
	    	this.instructorId = instructorId;
	    	this.createdAt = LocalDateTime.now();
	    }

	    // Getters and Setters

	    public Long getId() {
	        return courseId;
	    }

	    public void setId(Long courseId) {
	        this.courseId = courseId;
	    }
        
	    public String getTitle() {
	        return title;
	    }
	   

	    public void setTitle(String title) {
	        this.title = title;
	    }

	    public String getDescription() {
	        return description;
	    }
        
	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public String getThumbnailUrl() {
	        return thumbnailUrl;
	    }
        
	    public void setThumbnailUrl(String thumbnailUrl) {
	        this.thumbnailUrl = thumbnailUrl;
	    }

	    public String getCategory() {
	        return category;
	    }
	   
	    public void setCategory(String category) {
	        this.category = category;
	    }

	    public DifficultyLevel getDifficultyLevel() {
	        return level;
	    }
	    
	    public void setDifficultyLevel(DifficultyLevel level) {
	        this.level = level;
	    }

	    public VideoStatus getStatus() {
	        return status;
	    }
	   
	    public void setStatus(VideoStatus status) {
	        this.status = status;
	    }

	    public LocalDateTime getCreatedAt() {
	        return createdAt;
	    }

	    public void setCreatedAt(LocalDateTime createdAt) {
	        this.createdAt = createdAt;
	    }

	    public Long getInstructorId() {
	        return instructorId;
	    }
	    
	    public void setInstructorId(Long instructorId) {
	        this.instructorId = instructorId;
	    }
	    
		@Override
		public String toString() {
			return "Course [courseId=" + courseId + ", title=" + title + ", description=" + description
					+ ", thumbnailUrl=" + thumbnailUrl + ", category=" + category + ", level=" + level + ", status="
					+ status + ", createdAt=" + createdAt + ", instructorId=" + instructorId + "]";
		} 
	
	
}