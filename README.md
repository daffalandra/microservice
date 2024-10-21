# Back End Exercise Java

This project is a microservices built with Java Spring Boot. It consists of three services: a Listing service, a User service, and a Public API layer. The system allows users to manage properties available for rent or purchase.

## Features

- **User Management**: Register new users via a REST API.
- **Property Listings**: Create, view, and manage real estate listings.
- **RESTful APIs**: Public-facing endpoints for managing users and property listings.
- **Pagination and Filtering**: Fetch listings with pagination and filter by user ID.
- **Microservices Architecture**: Independent services for user and listing management.

## Project Structure

- **public-api**: This module contains the public API for fetching listings and users.
- **listing-service**: This service handles property listing data, including creation and retrieval.
- **user-service**: This service handles user management, including user creation and retrieval.

## Endpoints

### Public API
- `GET http://localhost:8080/public-api/listings`: Retrieve a list of property listings (supports pagination and optional `userId` filter).
- `POST http://localhost:8080/public-api/users`: Create a new user.
- `POST http://localhost:8080/public-api/listings`: Create a new property listing.

### Listing Service
- `GET http://localhost:8081/listings`: Retrieve listings (internal microservice endpoint).
- `POST http://localhost:8081/listings`: Create a new listing (internal microservice endpoint).

### User Service
- `GET http://localhost:8082/users`: Retrieve users (internal microservice endpoint).
- `POST http://localhost:8082/users`: Create a new user (internal microservice endpoint).

## Technologies Used

- **Java Spring Boot**: Backend framework.
- **H2 Database**: In-memory database for development and testing.
- **Microservices Architecture**: Separation of concerns via different services.
- **Gradle**: Dependency management.
- **IntelliJ IDEA**: IDE used for development.

## Getting Started

### Prerequisites

- Java 17+
- Maven 3+
- IntelliJ IDEA (recommended)
- H2 Database (embedded)

### Running the Services

1. Clone the repository:
   ```bash
   https://github.com/daffalandra/microservice.git

2. Navigate to the project directory:
```bash
   cd microservice

3. Run the microservices:
   Public API (runs on port 8080)
   Listing Service (runs on port 8081)
   User Service (runs on port 8082)
   
4. Testing the APIs
   Use a tool like Postman or curl to test the REST APIs.

