# Sisyphus Habit Tracker Backend

Welcome to the Sisyphus Habit Tracker Backend repository! This repository contains the backend codebase for our habit tracking web application built using Spring Boot with Java.

## Project Overview

The Sisyphus Habit Tracker Backend is responsible for handling user authentication, managing habits and their progress, and providing API endpoints for interaction with the frontend. It interacts with a PostgreSQL database to store user data and habit information.

## Installation

To set up the backend environment locally and start developing, follow these steps:

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/rahu1ramesh/sisyphus-backend.git
   ```

2. **Navigate to Project Directory**:
   ```bash
   cd sisyphus-backend
   ```

3. **Set Up PostgreSQL Database**:
    - Create a PostgreSQL database for the application.
    - Update the database configuration in `src/main/resources/application.properties` with your database credentials.

4. **Build the Project**:
   ```bash
   ./mvnw clean install
   ```

5. **Run the Application**:
   ```bash
   ./mvnw spring-boot:run
   ```

6. **Access the API**:
   The backend API will be accessible at `http://localhost:8080`.

## Configuration

Update the `src/main/resources/application.properties` file with your PostgreSQL database credentials:
```properties
# PostgreSQL Database (production)
spring.datasource.url=jdbc:postgresql://localhost:5432/sisyphus
spring.datasource.username=postgres
spring.datasource.password=password
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

# H2 Database (development)
#spring.datasource.url=jdbc:h2:mem:testdb
#spring.datasource.driverClassName=org.h2.Driver
#spring.datasource.username=sa
#spring.datasource.password=password
#spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
#spring.h2.console.enabled=true
```

## Usage

Once the backend environment is set up and the application server is running, you can start interacting with the API endpoints to perform CRUD operations on habits and manage user authentication.

### API Endpoints

- `/api/auth/login`: POST endpoint for user login.
- `/api/auth/logout`: POST endpoint for user logout.
- `/api/auth/register`: POST endpoint for user registration.
- `/api/habits/`: GET, POST endpoint for listing and creating habits.
- `/api/habits/{habitId}/`: GET, PUT, DELETE endpoint for retrieving, updating, and deleting a specific habit.
- `/api/habits/{habitId}/progress/`: GET, POST endpoint for retrieving and recording habit progress.

### Authentication

- To access protected API endpoints, include an authentication token in the request headers.
- Obtain an authentication token by logging in via the `/api/auth/login` endpoint.

## Contributing

Contributions to the Sisyphus Habit Tracker Backend are welcome! If you have any ideas, bug fixes, or new features to propose, please open an issue or submit a pull request. We appreciate your contributions to making the application better for everyone.

## License

This project is licensed under the [MIT License](LICENSE).
