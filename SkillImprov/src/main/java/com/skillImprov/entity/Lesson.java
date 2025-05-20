package com.skillImprov.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="lesson")
public class Lesson {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Foreign key to Course
    @Column(name = "course_id", nullable = false)
    private Long courseId; // You can use UUID if your Course uses UUID

    @Column(nullable = false, length = 200)
    private String title;

    @Column(name = "video_url")
    private String videoUrl;

    @Column(name = "order_index", nullable = false)
    private Integer orderIndex;

    
    @Column(name = "content_type", nullable = false, length = 20)
    private String contentType;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    // Constructors
    public Lesson() {}

    public Lesson(Long courseId, String title, String videoUrl, Integer orderIndex, String contentType) {
        this.courseId = courseId;
        this.title = title;
        this.videoUrl = videoUrl;
        this.orderIndex = orderIndex;
        this.contentType = contentType;
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
