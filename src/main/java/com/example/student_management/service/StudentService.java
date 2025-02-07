package com.example.student_management.service;

import com.example.student_management.model.Student;
import com.example.student_management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Говорит Spring, что это сервис
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired // Внедряем репозиторий в сервис
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Получить всех студентов
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Найти студента по ID
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    // Добавить студента
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    // Обновить студента
    public Student updateStudent(Long id, Student updatedStudent) {
        return studentRepository.findById(id).map(student -> {
            student.setName(updatedStudent.getName());
            student.setEmail(updatedStudent.getEmail());
            return studentRepository.save(student);
        }).orElseThrow(() -> new RuntimeException("Студент не найден"));
    }

    // Удалить студента
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
