package com.skillImprov.entity;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.skillImprov.enums.ContentType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="lesson")
@Component
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lessonId;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(name = "videoUrl")
    private String videoUrl;

    @Column(name = "orderIndex", nullable = false)
    private Integer orderIndex;

    @Enumerated(EnumType.STRING)
    @Column(name = "contentType", nullable = false, length = 20)
    private ContentType contentType;

    @Column(name = "createdAt", nullable = false)
    private LocalDateTime createdAt;
   
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courseId")
    private Course course;

    // Constructors
    public Lesson() {}

    public Lesson(Long lessonId, String title, String videoUrl, Integer orderIndex, ContentType contentType,
			LocalDateTime createdAt) {
		super();
		this.lessonId = lessonId;
		this.title = title;
		this.videoUrl = videoUrl;
		this.orderIndex = orderIndex;
		this.contentType = contentType;
		this.createdAt = createdAt;
	}

	public Lesson(Course course, String title, String videoUrl, Integer orderIndex, ContentType contentType) {
        this.course = course;
        this.title = title;
        this.videoUrl = videoUrl;
        this.orderIndex = orderIndex;
        this.contentType = contentType;
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters
	
	public Long getLessonId() {
		return lessonId;
	}

	public void setLessonId(Long lessonId) {
		this.lessonId = lessonId;
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

    public ContentType getContentType() {
        return contentType;
    }

    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Lesson lessonId=" + lessonId + ", courseId=" + course+ ", title=" + title + ", videoUrl=" + videoUrl
				+ ", orderIndex=" + orderIndex + ", contentType=" + contentType + ", createdAt=" + createdAt + "]";
	}

}
