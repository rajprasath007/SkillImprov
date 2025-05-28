package com.skillImprov.entity;

import java.time.LocalDateTime;

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
@Table(name = "quizAttempt")
@Component
public class QuizAttempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "quizId", nullable = false)
    private Quiz quiz;

    public QuizAttempt() {
		super();
	}
	@Column(name = "score", nullable = false)
    private Integer score;

    @Column(name = "attempted_at", nullable = false)
    private LocalDateTime attemptedAt;

    // Getters and Setters
    public Long getId() { 
    	return id; 
    	}
    public void setId(Long id) { 
    	this.id = id; 
    	}

    public QuizAttempt(Long id, User user, Quiz quiz, Integer score, LocalDateTime attemptedAt) {
		super();
		this.id = id;
		this.user = user;
		this.quiz = quiz;
		this.score = score;
		this.attemptedAt = attemptedAt;
	}
	public User getUser() { 
		return user;
		}
    public void setUser(User user) { 
    	this.user = user; 
    	}

    public Quiz getQuiz() { 
    	return quiz; 
    	}
    public void setQuiz(Quiz quiz) { 
    	this.quiz = quiz; 
    	}

    public Integer getScore() { 
    	return score; 
    	}
    public void setScore(Integer score) {
    	this.score = score;
    	}

    public LocalDateTime getAttemptedAt() { 
    	return attemptedAt;
    	}
    public void setAttemptedAt(LocalDateTime attemptedAt) { 
    	this.attemptedAt = attemptedAt; 
    	}
	@Override
	public String toString() {
		return "QuizAttempt [id=" + id + ", user=" + user + ", quiz=" + quiz + ", score=" + score + ", attemptedAt="
				+ attemptedAt + "]";
	}
    
}

