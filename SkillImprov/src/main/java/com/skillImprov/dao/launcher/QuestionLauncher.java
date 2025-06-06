package com.skillImprov.dao.launcher;

import com.skillImprov.dao.interfaces.QuestionDao;
import com.skillImprov.dao.interfaces.QuizDao;
import com.skillImprov.entity.Question;
import com.skillImprov.entity.Quiz;
import com.skillImprov.enums.QuestionType;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDateTime;

@SpringBootApplication(scanBasePackages = "com.skillImprov")
@EnableJpaRepositories(basePackages = "com.skillImprov.dao.interfaces")
@EntityScan(basePackages = "com.skillImprov.entity")
public class QuestionLauncher {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(QuestionLauncher.class, args);

        QuizDao quizDao = context.getBean(QuizDao.class);
        QuestionDao questionDao = context.getBean(QuestionDao.class);

        // Sample Quiz
        Quiz quiz = context.getBean(Quiz.class);
        quiz.setTitle("Java Quiz");
        quiz.setCreatedAt(LocalDateTime.now());
        quizDao.save(quiz);

        // Sample Question
        Question question = context.getBean(Question.class);
        question.setQuiz(quiz);
        question.setQuestionText("What is the size of an int in Java?");
        question.setQuestionType(QuestionType.MCQ); // Assuming this is an enum in your app
        questionDao.save(question);

        System.out.println("Question saved!");
        System.out.println(questionDao.findById(question.getQuestionId()).orElse(null));
    }
}
