package com.example.Spring.service;

import com.example.Spring.model.Student;
import com.example.Spring.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public void createStudent(Student student) { repository.save(student); }
    public List<Student> getAllStudents() { return repository.findAll(); }
    public Student getStudentById(int id) { return repository.findById(id); }
    public void updateStudent(int id, Student student) {
        student.setId(id);
        repository.update(student);
    }
    public void deleteStudent(int id) { repository.delete(id); }
}
