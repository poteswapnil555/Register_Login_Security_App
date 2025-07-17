# Register_Login_Security_App

A secure authentication backend built using **Java Spring Boot**, **Spring Security**, and **JWT**. Supports user registration, login, and role-based access control with encrypted passwords.

## 🚀 Tech Stack
- Java 17+
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- BCrypt
- Maven
- H2 / MySQL
- Lombok

## 🔐 Features
- User registration and login
- Secure JWT-based authentication
- Role-based access (USER / ADMIN)
- Password encryption using BCrypt
- Clean MVC structure with layered services

## 📁 Project Structure
```
src/
├── config/         # JWT filters and security config
├── controller/     # REST API endpoints
├── service/        # Business logic
├── model/          # Entity classes
├── repository/     # JPA repositories
```

## 📡 API Endpoints

| Method | Endpoint         | Description              |
|--------|------------------|--------------------------|
| POST   | /auth/register   | Register a new user      |
| POST   | /auth/login      | Login and receive token  |
| GET    | /user            | Protected endpoint       |

## 🛠️ Getting Started

```bash
git clone https://github.com/poteswapnil555/Register_Login_Security_App
cd Register_Login_Security_App
mvn spring-boot:run
```

## ✅ Requirements
- Java 17+
- Maven
- Any IDE (IntelliJ, Eclipse, VSCode)
