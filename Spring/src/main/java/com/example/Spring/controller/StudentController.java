package com.example.Spring.controller;

import com.example.Spring.model.Student;
import com.example.Spring.service.StudentService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public String createStudent(@RequestBody Student student) {
        service.createStudent(student);
        return "Student created";
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {
        return service.getStudentById(id);
    }

    @PutMapping("/{id}")
    public String updateStudent(@PathVariable int id, @RequestBody Student student) {
        service.updateStudent(id, student);
        return "Student updated";
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        service.deleteStudent(id);
        return "Student deleted";
    }
}
