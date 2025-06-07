package com.skillImprov.dao.launcher;

import com.skillImprov.dao.interfaces.CourseDao;
import com.skillImprov.dao.interfaces.LessonDao;
import com.skillImprov.dao.interfaces.OptionDao;
import com.skillImprov.dao.interfaces.QuestionDao;
import com.skillImprov.dao.interfaces.QuizDao;
import com.skillImprov.dao.interfaces.UserDao;
import com.skillImprov.entity.Course;
import com.skillImprov.entity.Lesson;
import com.skillImprov.entity.Option;
import com.skillImprov.entity.Question;
import com.skillImprov.entity.Quiz;
import com.skillImprov.entity.User;
import com.skillImprov.enums.ContentType;
import com.skillImprov.enums.DifficultyLevel;
import com.skillImprov.enums.QuestionType;
import com.skillImprov.enums.Role;
import com.skillImprov.enums.VideoStatus;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.skillImprov")
@EntityScan(basePackages = "com.skillImprov.entity")
public class OptionLauncher {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OptionLauncher.class, args);

        
        QuestionDao questionDao = context.getBean(QuestionDao.class);
        OptionDao optionDao = context.getBean(OptionDao.class);
        QuizDao quizDao = context.getBean(QuizDao.class);
        CourseDao courseDao = context.getBean(CourseDao.class);
        LessonDao lessonDao = context.getBean(LessonDao.class);
        UserDao userDao = context.getBean(UserDao.class);
        
        // Create User
        User user = context.getBean(User.class);
        user.setUsername("quiz_user2");
        user.setEmail("quiz_user5@example.com");
        user.setPassword("password");
        user.setRole(Role.STUDENT);
        user.setCreatedAt(LocalDateTime.now());
        userDao.save(user);
        
        // Create Course
        Course course = context.getBean(Course.class);
        course.setCategory("skill");
        course.setCreatedAt(LocalDateTime.now());
        course.setDescription("paravaiyai parandhavan iragu pol karaigiren");
        course.setDifficultyLevel(DifficultyLevel.BEGINNER);
        course.setStatus(VideoStatus.PUBLISHED);
        course.setThumbnailUrl("");
        course.setTitle("Semainga..");
        course.setUser(user);
        courseDao.save(course);
        
        // Create Lesson
        Lesson lesson = context.getBean(Lesson.class);
        lesson.setContentType(ContentType.PDF);
        lesson.setCourse(null);
        lesson.setCreatedAt(LocalDateTime.now());
        lesson.setOrderIndex(5);
        lesson.setTitle("sample_lesson");
        lesson.setVideoUrl("");
        lesson.setCourse(course);
        lessonDao.save(lesson);

        // Create Quiz
        Quiz quiz = context.getBean(Quiz.class);
        quiz.setLesson(lesson);
        quiz.setTitle("Spring Boot Basics Quiz");
        quiz.setCreatedAt(LocalDateTime.now());
        quizDao.save(quiz);
        
        // Create and save a question
        Question question = context.getBean(Question.class);
        question.setQuestionText("What is the capital of France?");
        question.setQuestionType(QuestionType.MCQ);
        question.setQuiz(quiz);
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
