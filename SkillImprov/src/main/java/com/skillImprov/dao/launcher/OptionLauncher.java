package com.skillImprov.dao.launcher;

import com.skillImprov.dao.interfaces.OptionDao;
import com.skillImprov.dao.interfaces.QuestionDao;
import com.skillImprov.entity.Option;
import com.skillImprov.entity.Question;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.skillImprov")
@EnableJpaRepositories(basePackages = "com.skillImprov.dao.interfaces")
@EntityScan(basePackages = "com.skillImprov.entity")
public class OptionLauncher {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OptionLauncher.class, args);

        QuestionDao questionDao = context.getBean(QuestionDao.class);
        OptionDao optionDao = context.getBean(OptionDao.class);

        // Create and save a question
        Question question = context.getBean(Question.class);
        question.setQuestionText("What is the capital of France?");
        questionDao.save(question);

        // Create and save an option
        Option option = context.getBean(Option.class);
        option.setOptionText("Paris");
        option.setIsCorrect(true);
        option.setQuestion(question);
        optionDao.save(option);

        System.out.println("Option saved!");

        // Fetch and print the option
        Option fetchedOption = optionDao.findById(option.getOptionId()).orElse(null);
        System.out.println("Fetched Option: " + fetchedOption);
    }
}
