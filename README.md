# Register_Login_Security_App

A secure user authentication backend built with **Java Spring Boot**. Implements robust registration and login functionality using **Spring Security**, **JWT**, and **BCrypt password hashing**. Ideal for integrating into full-stack apps or microservices that require role-based access control.

## 🔧 Tech Stack

- Java 17+
- Spring Boot
- Spring Security
- JWT (JSON Web Tokens)
- BCrypt
- Maven
- H2 or MySQL (configurable)
- Lombok

## 🚀 Features

- 🔐 User registration and login
- 🛡️ Role-based access control (e.g., USER/ADMIN)
- 🧂 Password hashing with BCrypt
- 📄 Stateless JWT-based authentication
- ✅ RESTful API architecture

## 📦 API Endpoints

| Method | Endpoint    | Description              |
|--------|-------------|--------------------------|
| POST   | /register   | Register a new user      |
| POST   | /login      | Authenticate & return JWT|
| GET    | /profile    | Fetch user profile       |

## ▶️ Getting Started

1. Clone the repo  
   `git clone https://github.com/poteswapnil555/Register_Login_Security_App`

2. Run the app  
   ```bash
   cd Register_Login_Security_App
   mvn spring-boot:run
