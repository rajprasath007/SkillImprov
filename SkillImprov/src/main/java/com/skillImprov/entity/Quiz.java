package com.skillImprov.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "quiz")
@Component
public class Quiz {
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "quizId")
	    private Long quizId;

	    @Column(name = "title",nullable = false)
	    private String title;

	    @CreationTimestamp
	    @Column(name = "createdAt", nullable = false, updatable = false)
	    private LocalDateTime createdAt;
	    
	    // Foreign Key to Lesson
	    @ManyToOne
	    @JoinColumn(name = "lessonId", nullable = false)
	    private Lesson lesson;

	    // Constructors
	    public Quiz() {}

	    public Quiz(Long quizId, String title, LocalDateTime createdAt) {
			super();
			this.quizId = quizId;
			this.title = title;
			this.createdAt = createdAt;
		}

	    public Quiz(Lesson lesson, String title, LocalDateTime createdAt) {
	        this.lesson = lesson;
	        this.title = title;
	        this.createdAt = createdAt;
	    }

	    // Getters and Setters
	    public Long getQuizId() {
	        return quizId;
	    }

	    public void setQuizId(Long quizId) {
	        this.quizId = quizId;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public void setTitle(String title) {
	        this.title = title;
	    }

	    public LocalDateTime getCreatedAt() {
	        return createdAt;
	    }

	    public void setCreatedAt(LocalDateTime createdAt) {
	        this.createdAt = createdAt;
	    }
	    
	    public Lesson getLesson() {
	        return lesson;
	    }

	    public void setLesson(Lesson lesson) {
	        this.lesson = lesson;
	    }

	    // toString() - Avoid accessing LAZY fields like lesson.toString() directly
	    @Override
	    public String toString() {
	        return "Quiz [quizId=" + quizId + ", title=" + title + ", createdAt=" + createdAt + "]";
	    }

}

