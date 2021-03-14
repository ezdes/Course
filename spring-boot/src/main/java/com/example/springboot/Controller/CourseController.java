package com.example.springboot.Controller;

import com.example.springboot.Entity.Course;
import com.example.springboot.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/course")
    public List<Course> findAll() {
        return courseService.findAll();
    }

    @GetMapping("/course/{courseId}")
    public Course findById(@PathVariable Long courseId) {
        return courseService.findById(courseId);
    }

    @PostMapping("/course")
    public Course addStudent(@RequestBody Course course) {
        return courseService.create(course);
    }

    @DeleteMapping("/course/{courseId}")
    public void deleteCourse(@PathVariable Long courseId) {
        courseService.deleteById(courseId);
    }

    @PutMapping("/course/{courseId}")
    public Course updateCourse(@RequestBody Course newCourse, @PathVariable Long courseId) {
        return courseService.updateById(newCourse, courseId);
    }
}
