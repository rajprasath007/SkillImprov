package com.skillImprov.entity;


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
@Table(name = "options")
@Component
public class Option {

    @Id
    @Column(name = "optionId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long optionId;

    @Column(name = "optionText", nullable = false)
    private String optionText;

    @Column(name = "isCorrect", nullable = false)
    private Boolean isCorrect;
    
    @ManyToOne
    @JoinColumn(name = "questionId", nullable = false)
    private Question question;
    
    // Constructors
    
    public Option() {}
    
    public Option(Long optionId, String optionText, Boolean isCorrect) {
		super();
		this.optionId = optionId;
		this.optionText = optionText;
		this.isCorrect = isCorrect;
	}

    // Getters and Setters

    public Long getOptionId() {
        return optionId;
    }

	public void setOptionId(Long optionId) {
        this.optionId = optionId;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

    public Boolean getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(Boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    @Override
    public String toString() {
        return "Option [id=" + optionId + ", optionText=" + optionText + ", isCorrect=" + isCorrect + "]";
    }
}

