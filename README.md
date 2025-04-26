# DreamSellers - ISM Project

## Project Description

This project consists of two parts:
- **Backend**: a server-side application written in Java (Spring Boot)
- **Frontend**: a client-side application written in Angular (TypeScript)

The goal of the project was:
- To create a simple frontend client for the existing REST API
- To implement aspect-oriented programming (AOP) for collecting API usage statistics

---

## Technologies Used

- **Backend**:
    - Java 17
    - JDK 21
    - Spring Boot
    - Maven

- **Frontend**:
    - TypeScript
    - Angular 17
    - Node.js (recommended LTS version)

---

## System Requirements

Before running the project, make sure you have the following installed:

- Java Development Kit (JDK) 21
- Maven (recommended version 3.8+)
- Node.js (recommended LTS version, e.g., 20.x)
- npm (comes with Node.js)

---

## Build and Run Instructions

### Backend

1. Navigate to the main project directory (where the `pom.xml` file is located).
2. Build the project:
   ```bash
   mvn clean install
   ```
3. Run the backend application:
   ```bash
   mvn spring-boot:run
   ```
4. The backend will be available at:
   ```
   http://localhost:8080
   ```

### Frontend

1. Navigate to the `frontend/` directory:
   ```bash
   cd frontend
   ```
2. Install dependencies:
   ```bash
   npm install
   ```
3. Run the frontend application:
   ```bash
   npm start
   ```
4. The frontend will be available at:
   ```
   http://localhost:4200
   ```

---

## Features

### Backend

- REST API for managing users, items, and vendors.
- Aspect-Oriented Programming (AOP):
    - Collecting the number of controller method calls.
    - Tracking the highest price among the retrieved items (`findAll`).
- Statistics available via the endpoint:
  ```
  GET /statistics
  ```

### Frontend

- User registration and login
- Dashboard displaying available items
- Vendor creation
- Sidebar for navigation throughout the system

---

## Notes

- `target/` (backend) and `node_modules/` (frontend) directories are excluded from the ZIP archive.
- The project is prepared to be easily run on any environment meeting the above requirements.
- Full security implementation is not included (according to the lab instructions).

---

## Author

Jakub Wójciak;
269321;
ISM Laboratory;
Group 2
