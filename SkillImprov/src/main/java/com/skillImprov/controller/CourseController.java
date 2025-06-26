package com.skillImprov.controller;


import com.skillImprov.entity.Course;
import com.skillImprov.entity.User;
import com.skillImprov.enums.VideoStatus;
import com.skillImprov.services.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin(origins = "*") // Allow all origins; customize for security in production
public class CourseController {

    @Autowired
    private CourseService courseService;

  
    @PostMapping
    public ResponseEntity<Course> saveCourse(@RequestBody Course course) {
        return ResponseEntity.ok(courseService.save(course));
    }

   
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        Optional<Course> course = courseService.findById(id);
        return course.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

 
    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.findAll();
    }

   
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourseById(@PathVariable Long id) {
        if (courseService.existsById(id)) {
            courseService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{course}")
    public ResponseEntity<Object> delete(Course course) {
    	courseService.delete(course);
        return ResponseEntity.noContent().build();
        
    }

    
    @GetMapping("/status/{status}")
    public List<Course> getCoursesByStatus(@PathVariable VideoStatus status) {
        return courseService.findByStatus(status);
    }

    
    @GetMapping("/category/{category}")
    public List<Course> getCoursesByCategory(@PathVariable String category) {
        return courseService.findByCategory(category);
    }

   
    @GetMapping("/instructor/{userId}")
    public List<Course> getCoursesByUser(@PathVariable Long userId) {
        User user = new User(); // You should fetch user by service if validation needed
        user.setUserId(userId);
        return courseService.findByUser(user);
    }

   
    @GetMapping("/count")
    public long countCourses() {
        return courseService.count();
    }
}

