package com.skillImprov.dao.launcher;

import com.skillImprov.dao.interfaces.CourseDao;
import com.skillImprov.dao.interfaces.LessonDao;
import com.skillImprov.dao.interfaces.QuestionDao;
import com.skillImprov.dao.interfaces.QuizDao;
import com.skillImprov.dao.interfaces.UserDao;
import com.skillImprov.entity.Course;
import com.skillImprov.entity.Lesson;
import com.skillImprov.entity.Question;
import com.skillImprov.entity.Quiz;
import com.skillImprov.entity.User;
import com.skillImprov.enums.ContentType;
import com.skillImprov.enums.DifficultyLevel;
import com.skillImprov.enums.QuestionType;
import com.skillImprov.enums.Role;
import com.skillImprov.enums.VideoStatus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDateTime;

@SpringBootApplication(scanBasePackages = "com.skillImprov")
@EntityScan(basePackages = "com.skillImprov.entity")
public class QuestionLauncher {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(QuestionLauncher.class, args);

        UserDao userDao = context.getBean(UserDao.class);
        QuizDao quizDao = context.getBean(QuizDao.class);
        QuestionDao questionDao = context.getBean(QuestionDao.class);
        CourseDao courseDao = context.getBean(CourseDao.class);
        LessonDao lessonDao = context.getBean(LessonDao.class);
        
        // Create User
        User user = context.getBean(User.class);
        user.setUsername("quiz_user5");
        user.setEmail("ques_user@example.com");
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
        lesson.setCreatedAt(LocalDateTime.now());
        lesson.setOrderIndex(5);
        lesson.setTitle("sample_lesson");
        lesson.setVideoUrl("");
        lesson.setCourse(course);
        lessonDao.save(lesson);
        
        // Sample Quiz
        Quiz quiz = context.getBean(Quiz.class);
        quiz.setTitle("Java Quiz");
        quiz.setCreatedAt(LocalDateTime.now());
        quiz.setLesson(lesson);
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
