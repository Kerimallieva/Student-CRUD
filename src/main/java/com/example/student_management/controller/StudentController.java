package com.example.student_management.controller;

import com.example.student_management.model.Student;
import com.example.student_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students") // Базовый URL для всех методов
public class StudentController {

    private final StudentService studentService;

    @Autowired // Внедряем сервис в контроллер
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Получить всех студентов
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Получить студента по ID
    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    // Добавить студента
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    // Обновить студента
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
        return studentService.updateStudent(id, updatedStudent);
    }

    // Удалить студента
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}
