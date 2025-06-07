package com.skillImprov.entity;

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
	@Column(name = "progressId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long progressId;

    @Column(nullable = false)
    private float progressPercentage; // e.g., 75.50 (% complete)

    @Column(name = "updatedAt", nullable = false)
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId", nullable = false)
	private User user;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "lessonId", nullable = false)
	private Lesson lesson;
    
    // Constructors
    public Progress() {}

    public Progress(Long progressId, float progressPercentage, LocalDateTime updatedAt) {
		super();
		this.progressId = progressId;
		this.progressPercentage = progressPercentage;
		this.updatedAt = updatedAt;
	}

	public Progress(Long userId, Long lessonId, float progressPercentage, User user, Lesson lesson) {
        this.user = user;
        this.lesson = lesson;
        this.progressPercentage = progressPercentage;
        this.updatedAt = LocalDateTime.now();
    }

    // Getters and Setters

    public Long getProgressId() {
		return progressId;
	}

	public void setProgressId(Long progressId) {
		this.progressId = progressId;
	}

	public float getProgressPercentage() {
        return progressPercentage;
    }

    public void setProgress(float progressPercentage) {
        this.progressPercentage = progressPercentage;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
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

	@Override
	public String toString() {
		return "Progress [progressId=" + progressId + ", userId=" + user + ", lessonId=" + lesson + ", progress="
				+ progressPercentage + ", updatedAt=" + updatedAt + "]";
	}

}
