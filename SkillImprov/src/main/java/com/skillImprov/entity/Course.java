package com.skillImprov.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="courseId")
	private int courseId;
	@Column(name="courseTitle")
	private String courseTitle;
	@Column(name="fullDescription")
	
	private String fullDescription;
	@Column(name = "thumbnail_url")
    private String thumbnailUrl;

    @Column(name="category")
    private String category;

   
    @Column(name="level")
    private String level;

    
    @Column(name="status")
    private Boolean status;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    // Foreign Key Reference
    @Column(name = "instructor_id", nullable = false)
    private Long instructorId; // You can use UUID if your User entity uses UUID

    // Constructors
    public Course() {}

    public Course(String courseTitle, String fullDescription, String thumbnailUrl, String category,
                  String level, Boolean status, Long instructorId) {
        this.courseTitle = courseTitle;
        this.fullDescription = fullDescription;
        this.thumbnailUrl = thumbnailUrl;
        this.category = category;
        this.level = level;
        this.status = status;
        this.instructorId = instructorId;
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters

    public int getCourseId() {
        return courseId;
    }

    public void setId(Long id) {
        this.courseId = courseId;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
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
   

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
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

	
	
}
