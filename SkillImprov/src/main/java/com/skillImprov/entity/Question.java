package com.skillImprov.entity;

import org.springframework.stereotype.Component;

import com.skillImprov.enums.QuestionType;

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
@Table(name = "question")
@Component
public class Question {

    @Id
    @Column(name = "questionId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    @Column(name = "questionText", columnDefinition = "TEXT", nullable = false)
    private String questionText;

    @Enumerated(EnumType.STRING)
    @Column(name = "questionType", nullable = false)
    private QuestionType questionType;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "quizId", nullable = false)
    private Quiz quiz;

    // Constructors
    public Question() {
    }

    public Question(Long questionId, String questionText, QuestionType questionType) {
		super();
		this.questionId = questionId;
		this.questionText = questionText;
		this.questionType = questionType;
	}



	public Question(Quiz quiz, String questionText, QuestionType questionType) {
        this.quiz = quiz;
        this.questionText = questionText;
        this.questionType = questionType;
    }

    // Getters and Setters

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long id) {
        this.questionId = id;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + questionId +
                ", quiz=" + (quiz != null ? quiz.getQuizId() : null) +
                ", questionText='" + questionText + '\'' +
                ", questionType=" + questionType +
                '}';
    }

	
}

