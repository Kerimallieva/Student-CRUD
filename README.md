# **Student Management System (Spring Boot CRUD API)**  

## **Описание**  
Этот проект – простая REST API система управления студентами с использованием **Spring Boot**, **Spring Data JPA** и **H2 Database**. Позволяет:  
✅ Добавлять студентов  
✅ Получать список всех студентов  
✅ Искать студента по ID  
✅ Обновлять данные студента  
✅ Удалять студента  

## **Технологии**  
- **Java 17+**  
- **Spring Boot** (Spring Web, Spring Data JPA)  
- **H2 Database** (временная база данных)  
- **Maven** (для управления зависимостями)  

---

## **1. Запуск проекта**  

### **1.1. Склонировать репозиторий:**  
```sh
git clone https://github.com/твой-репозиторий.git
cd student-management
```

### **1.2. Запустить приложение:**  
В терминале выполнить:  
```sh
mvn spring-boot:run
```
После запуска API будет доступно по адресу:  
```
http://localhost:8080
```

---

## **2. Настройки базы данных**  
Проект использует **H2 Database** (в памяти).  
Настройки находятся в `src/main/resources/application.properties`:  

```properties
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

spring.datasource.url=jdbc:h2:mem:studentdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
```
Открыть базу данных можно в браузере:  
```
http://localhost:8080/h2-console
```
**JDBC URL:** `jdbc:h2:mem:studentdb`  
Логин: `sa`, пароль: (пусто)  

---

## **3. API Эндпоинты**  

| Метод | URL | Описание | Пример запроса |
|--------|---------------------------------|-------------------------|-----------------|
| **GET** | `/students` | Получить всех студентов | `curl -X GET http://localhost:8080/students` |
| **GET** | `/students/{id}` | Получить студента по ID | `curl -X GET http://localhost:8080/students/1` |
| **POST** | `/students` | Добавить студента | `curl -X POST -H "Content-Type: application/json" -d '{"name":"Иван","email":"ivan@example.com"}' http://localhost:8080/students` |
| **PUT** | `/students/{id}` | Обновить данные студента | `curl -X PUT -H "Content-Type: application/json" -d '{"name":"Иван Петров","email":"ivan.petrov@example.com"}' http://localhost:8080/students/1` |
| **DELETE** | `/students/{id}` | Удалить студента | `curl -X DELETE http://localhost:8080/students/1` |

### **3.1. Примеры JSON-запросов**
#### ➤ **Добавление студента (POST `/students`)**
```json
{
  "name": "Иван Иванов",
  "email": "ivan@example.com"
}
```

#### ➤ **Обновление студента (PUT `/students/{id}`)**
```json
{
  "name": "Иван Петров",
  "email": "ivan.petrov@example.com"
}
```

---

## **4. Структура проекта**  

```
student-management/
│── src/main/java/com/example/studentmanagement/
│   ├── model/           # Класс Student (модель данных)
│   ├── repository/      # Интерфейс StudentRepository (работа с БД)
│   ├── service/         # Класс StudentService (логика приложения)
│   ├── controller/      # Класс StudentController (REST API)
│── src/main/resources/
│   ├── application.properties  # Конфигурация базы данных
│── pom.xml             # Файл зависимостей Maven
│── README.md           # Документация проекта
```

---

## **5. Разработка и улучшение**  
📌 Возможные улучшения проекта:  
- ✅ **Добавить валидацию данных**  
- ✅ **Переключиться на PostgreSQL или MySQL**  
- ✅ **Добавить логирование запросов**  
- ✅ **Создать фронтенд на React/Vue**  

