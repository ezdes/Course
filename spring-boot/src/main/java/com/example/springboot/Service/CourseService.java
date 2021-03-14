package com.example.springboot.Service;

import com.example.springboot.Entity.Course;
import com.example.springboot.Exceptions.ResourceNotFoundException;
import com.example.springboot.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course create(Course course) {
        return courseRepository.save(course);
    }

    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public Course findById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    public Course updateById(Course newCourse, Long id) {
        return courseRepository.findById(id)
                .map(course -> {
                    course.setName(newCourse.getName());
                    course.setDescription(newCourse.getDescription());
                    course.setStartDate(newCourse.getStartDate());
                    course.setTeacherId(newCourse.getTeacherId());
                    return courseRepository.save(course);
                })
                .orElseThrow(ResourceNotFoundException::new);
    }
}
