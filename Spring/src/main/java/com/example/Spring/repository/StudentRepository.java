package com.example.Spring.repository;

import com.example.Spring.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class StudentRepository {
    private final JdbcTemplate jdbcTemplate;

    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int save(Student student) {
        String sql = "INSERT INTO students (name, email, course) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, student.getName(), student.getEmail(), student.getCourse());
    }

    public List<Student> findAll() {
        String sql = "SELECT * FROM students";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Student(rs.getInt("id"), rs.getString("name"),
                        rs.getString("email"), rs.getString("course")));
    }

    public Student findById(int id) {
        String sql = "SELECT * FROM students WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
                new Student(rs.getInt("id"), rs.getString("name"),
                        rs.getString("email"), rs.getString("course")));
    }

    public int update(Student student) {
        String sql = "UPDATE students SET name=?, email=?, course=? WHERE id=?";
        return jdbcTemplate.update(sql, student.getName(), student.getEmail(), student.getCourse(), student.getId());
    }

    public int delete(int id) {
        String sql = "DELETE FROM students WHERE id=?";
        return jdbcTemplate.update(sql, id);
    }
}
