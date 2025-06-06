package com.skillImprov.dao.launcher;

import com.skillImprov.dao.interfaces.ProgressDao;
import com.skillImprov.dao.interfaces.UserDao;
import com.skillImprov.dao.interfaces.LessonDao;
import com.skillImprov.entity.Progress;
import com.skillImprov.entity.User;
import com.skillImprov.entity.Lesson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDateTime;

@SpringBootApplication(scanBasePackages = "com.skillImprov")
@EnableJpaRepositories(basePackages = "com.skillImprov.dao.interfaces")
@EntityScan(basePackages = "com.skillImprov.entity")
public class ProgressLauncher {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ProgressLauncher.class, args);

        ProgressDao progressDao = context.getBean(ProgressDao.class);
        UserDao userDao = context.getBean(UserDao.class);
        LessonDao lessonDao = context.getBean(LessonDao.class);

        // Sample User
        User user = context.getBean(User.class);
        user.setUsername("progress_user");
        user.setEmail("progress_user@example.com");
        user.setPassword("test123");
        userDao.save(user);

        // Sample Lesson
        Lesson lesson = context.getBean(Lesson.class);
        lesson.setTitle("Java Basics");
        lesson.setVideoUrl("http://example.com/video.mp4");
        lesson.setOrderIndex(1);
        lesson.setContentType(com.skillImprov.enums.ContentType.VIDEO);
        lesson.setCreatedAt(LocalDateTime.now());
        lessonDao.save(lesson);

        // Sample Progress
        Progress progress = context.getBean(Progress.class);
        progress.setUser(user);
        progress.setLesson(lesson);
        progress.setProgress(85.5f);
        progress.setUpdatedAt(LocalDateTime.now());
        progressDao.save(progress);

        System.out.println("Progress saved!");
        System.out.println(progressDao.findById(progress.getProgressId()).orElse(null));
    }
}
