package com.skillImprov.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Quiz {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "quizId")
	    private Long quizId;

	    // Foreign Key to Lesson
	    @ManyToOne
	    @JoinColumn(name = "lessonId", nullable = false)
	    private Lesson lesson;

	    @Column(nullable = false)
	    private String title;

	    @CreationTimestamp
	    @Column(name = "created_at", nullable = false, updatable = false)
	    private LocalDateTime createdAt;

	    // Constructors
	    public Quiz() {}

	    public Quiz(Lesson lesson, String title) {
	        this.lesson = lesson;
	        this.title = title;
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

	    public Lesson getLesson() {
	        return lesson;
	    }

	    public void setLesson(Lesson lesson) {
	        this.lesson = lesson;
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

	    // toString() - Avoid accessing LAZY fields like lesson.toString() directly
	    @Override
	    public String toString() {
	        return "Quiz [quizId=" + quizId + ", title=" + title + ", createdAt=" + createdAt + "]";
	    }

}
