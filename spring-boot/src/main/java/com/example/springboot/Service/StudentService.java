package com.example.springboot.Service;

import com.example.springboot.Entity.Student;
import com.example.springboot.Exceptions.ResourceNotFoundException;
import com.example.springboot.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student create(Student theStudent) {
        return studentRepository.save(theStudent);
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    public Student updateById(Student newStudent, Long id) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setFirstName(newStudent.getFirstName());
                    student.setLastName(newStudent.getLastName());
                    student.setEmail(newStudent.getEmail());
                    student.setAge(newStudent.getAge());
                    student.setCourseId(newStudent.getCourseId());
                    return studentRepository.save(student);
                })
                .orElseThrow(ResourceNotFoundException::new);
    }
}
