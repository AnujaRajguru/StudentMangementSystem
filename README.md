#  Student Management System - Spring Boot Application

This is a RESTful web application for managing student records and courses using Spring Boot. It includes features like student registration, course management, course assignment, and profile updates.

---

##  Features

- Add and fetch student records
- Add and manage multiple courses
- Assign courses to students
- Search students by name or course
- JWT-based authentication for secured endpoints
- Swagger integration for API documentation

---

## Authentication & Authorization

JWT-based login for students using:

- **Student Code**
- **Date of Birth**

Secure endpoints with token validation.

**Admin credentials**
  
- username=admin
- password=admin@123

---

##  Tech Stack

- **Java 17**
- **Spring Boot 3.4**
- **Spring Data JPA**
- **H2 Database**
- **Lombok**
- **JWT (JSON Web Token)**
- **Swagger**
- **JUnit 5 + Mockito**

---

##  Getting Started

### Prerequisites

- Java 17 or above
- Maven 3.9
- IDE (IntelliJ)

###  Swagger API

- http://localhost:8080/swagger-ui/index.html

###  H2 Database API

- http://localhost:8080/h2-console
- username=sa
- password=pass

###  Project Structure

```
src
 └── main
      └── java/com/example/StudentManagementSystem
          ├── controller         # REST controllers
          ├── service            # Business logic
          ├── repository         # JPA repositories
          ├── entity             # Entity classes (Student, Course, etc.)
          ├── security           # JWT Authentication and Filters
          └── config             # Configuration classes (CORS, Swagger, etc.)
 └── test
      └── java/com/example/StudentManagementSystem
          └── controller         # Unit tests for controllers
```
### Clone and Run

``` bash
git clone https://github.com/AnujaRajguru/StudentMangementSystem.git
cd student-management-system
mvn spring-boot:run
```

