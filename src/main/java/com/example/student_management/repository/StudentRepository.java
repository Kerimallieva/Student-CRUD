package com.example.student_management.repository;

import com.example.student_management.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // Помечает этот класс как репозиторий
public interface StudentRepository extends JpaRepository<Student, Long> {
    // Дополнительный метод для поиска по email
    Optional<Student> findByEmail(String email);
}
