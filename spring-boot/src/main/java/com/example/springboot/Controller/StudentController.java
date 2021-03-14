package com.example.springboot.Controller;

import com.example.springboot.Entity.Student;
import com.example.springboot.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/student/{studentId}")
    public Student findById(@PathVariable Long studentId){
        return studentService.findById(studentId);
    }

    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student) {
        return studentService.create(student);
    }

    @PutMapping("/student/{studentId}")
    public Student updateStudent(@RequestBody Student newStudent, @PathVariable Long studentId) {
        return studentService.updateById(newStudent, studentId);
    }

    @DeleteMapping("/student/{studentId}")
    public void deleteStudent(@PathVariable Long studentId) {
        studentService.deleteById(studentId);
    }
}
