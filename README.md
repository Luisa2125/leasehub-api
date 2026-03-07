# Real Estate API

A REST API for managing users and properties with secure authentication using JWT.  
Built with Spring Boot and Spring Security.

---

## Features

- User registration and authentication
- JWT-based security
- Role-based authorization
- Property creation and management
- Protected endpoints
- Stateless authentication

---

## Tech Stack

- Java 17+
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- Maven
- JPA / Hibernate
- MySQL (or H2)

---

## Project Structure

```
src/main/java/com/example/realestate
│
├── config
│   └── SecurityConfig.java
│
├── controller
│   ├── AuthController.java
|   ├── UserController.java
│   └── PropertyController.java   
│
├── dto
│   ├── LoginRequest.java
│   ├── LoginResponse.java
│   ├── PropertyRequest.java
│   ├── PropertyResponse.java
│   ├── UserRequest.java
│   └── UserResponse.java
│
├── enum
│   ├── Role.java
|   └── Status.java
|
├── exception
│   ├── EmailAlreadyExistsException.java
│   ├── GlobalExceptionHandler.java
|   ├── PropertyAlreadyExistsException.java
|   └── ResourceNotFoundException.java
|
├── model
│   ├── User.java
│   ├── Property.java
|   ├── Lease.java
|   └── Payment.java
│
├── repository
│   ├── UserRepository.java
│   └── PropertyRepository.java
│
├── security
│   ├── JwtAuthenticationFilter.java
│   └── JwtService.java
│
└── service
    ├── UserService.java
    └── PropertyService.java
```

---

## Authentication Flow

1. User registers or logs in via `/auth/login`
2. Server validates credentials
3. Server generates a JWT token
4. Client sends the token in the `Authorization` header

Example:

```
Authorization: Bearer <your_token>
```

5. `JwtAuthenticationFilter` validates the token for every protected request

---

## API Endpoints

### Authentication

| Method | Endpoint | Description |
|------|------|------|
| POST | `/auth/register` | Register new user |
| POST | `/auth/login` | Login and receive JWT |

---

### Users

| Method | Endpoint | Description |
|------|------|------|
| GET | `/users` | Get all users (secured) |

---

### Properties

| Method | Endpoint | Description |
|------|------|------|
| GET | `/properties` | Get all properties |
| POST | `/properties` | Create property (secured) |
| GET | `/properties/{id}` | Get property by ID |

---

## Running the Project

### 1 Clone repository

```
git clone https://github.com/yourusername/real-estate-api.git
```

### 2 Navigate into project

```
cd real-estate-api
```

### 3 Run application

```
mvn spring-boot:run
```

The server will start on:

```
http://localhost:8080
```

---

## Example Login Request

```
POST /auth/login
```

Body:

```json
{
  "email": "user@test.com",
  "password": "password123"
}
```

Response:

```json
{
  "token": "jwt_token_here"
}
```

---

## Security

- Passwords are encrypted
- Stateless authentication using JWT
- Protected endpoints require a valid token
- Token is validated in `JwtAuthenticationFilter`

---

## Future Improvements

- Role-based authorization (`ADMIN`, `USER`)
- Property images upload
- Pagination and filtering
- Swagger/OpenAPI documentation
- Docker deployment

---

## Author

Luisa Arboleda Zapata
