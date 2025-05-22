package com.skillImprov.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="progress")
@Component
public class Progress{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long progressId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lesson_id", nullable = false)
	private Lesson lesson;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal progress; // e.g., 75.50 (% complete)

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    // Constructors
    public Progress() {}

    public Progress(Long userId, Long lessonId, BigDecimal progress) {
        this.user = user;
        this.lesson = lesson;
        this.progress = progress;
        this.updatedAt = LocalDateTime.now();
    }

    // Getters and Setters

    public Long getId() {
        return progressId;
    }

    public void setId(Long progressId) {
        this.progressId = progressId;
    }

   

    public Long getProgressId() {
		return progressId;
	}

	public void setProgressId(Long progressId) {
		this.progressId = progressId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Lesson getLesson() {
		return lesson;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}

	public BigDecimal getProgress() {
        return progress;
    }

    public void setProgress(BigDecimal progress) {
        this.progress = progress;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

	@Override
	public String toString() {
		return "Progress [progressId=" + progressId + ", userId=" + user + ", lessonId=" + lesson + ", progress="
				+ progress + ", updatedAt=" + updatedAt + "]";
	}

}
