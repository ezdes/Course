package com.example.springboot.Service;

import com.example.springboot.Entity.Teacher;
import com.example.springboot.Exceptions.ResourceNotFoundException;
import com.example.springboot.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher create(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher updateById(Teacher newTeacher, Long id) {
        return teacherRepository.findById(id)
                .map(teacher -> {
                    teacher.setFirstName(newTeacher.getFirstName());
                    teacher.setLastName(newTeacher.getLastName());
                    teacher.setEmail(newTeacher.getEmail());
                    teacher.setAge(newTeacher.getAge());
                    return teacherRepository.save(teacher);
                })
                .orElseThrow(ResourceNotFoundException::new);
    }

    public void deleteById(Long id) {
        teacherRepository.deleteById(id);
    }

    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    public Teacher findById(Long id) {
        return teacherRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }
}
