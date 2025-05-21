
package com.skillImprov.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="proges")
@Component
public class Progres {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long progesId;

    @Column(name = "user_id", nullable = false)
    private Long userId; // Use UUID if your User entity uses UUID

    @Column(name = "lesson_id", nullable = false)
    private Long lessonId; // Use UUID if your Lesson entity uses UUID

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal progress; // e.g., 75.50 (% complete)

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    // Constructors
    public Progres() {}

    public Progres(Long userId, Long lessonId, BigDecimal progress) {
        this.userId = userId;
        this.lessonId = lessonId;
        this.progress = progress;
        this.updatedAt = LocalDateTime.now();
    }

    // Getters and Setters

    public Long getId() {
        return progesId;
    }

    public void setId(Long id) {
        this.progesId = progesId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getLessonId() {
        return lessonId;
    }

    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
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

}
