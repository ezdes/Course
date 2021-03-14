package com.example.springboot.Controller;

import com.example.springboot.Entity.Teacher;
import com.example.springboot.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teacher")
    public List<Teacher> findAll() {
        return teacherService.findAll();
    }

    @GetMapping("/teacher/{teacherId}")
    public Teacher findById(@PathVariable Long teacherId) {
        return teacherService.findById(teacherId);
    }

    @PostMapping("/teacher")
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        return teacherService.create(teacher);
    }

    @PutMapping("/teacher/{teacherId}")
    public Teacher updateTeacher(@RequestBody Teacher newTeacher, @PathVariable Long teacherId) {
        return teacherService.updateById(newTeacher, teacherId);
    }

    @DeleteMapping("/teacher/{teacherId}")
    public void deleteTeacher(@PathVariable Long teacherId) {
        teacherService.deleteById(teacherId);
    }
}
