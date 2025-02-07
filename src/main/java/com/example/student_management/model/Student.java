package com.example.student_management.model;

import jakarta.persistence.*;

@Entity // Указывает, что этот класс — таблица в базе данных
@Table(name = "students") // Название таблицы
public class Student {

    @Id // Указывает, что это первичный ключ
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Авто-генерация ID
    private Long id;

    @Column(nullable = false) // Поле не может быть пустым
    private String name;

    @Column(nullable = false, unique = true) // Email должен быть уникальным
    private String email;

    public Student() {} // Пустой конструктор (нужен для JPA)

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Геттеры и сеттеры (чтобы получать и менять данные)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
