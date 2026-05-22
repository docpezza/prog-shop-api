## Description

This is a REST API built with Spring Boot designed to manage products and categories for a workshop/shop management system.

The project uses JPA relationships between products and categories and stores data in a MySQL database.

It also includes CRUD operations, DTOs, validation, custom exception handling and RESTful API design principles.

## Technologies

- Java17
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Jakarta Validation
- REST API
- Postman

## Features

- CRUD operations for products and categories
- DTO Request/Response architecture
- JPA entity relationships
- Global exception handling
- Custom exceptions handling
- Validation with Jakarta Validation
- Custom repository queries

## API Endpoints

### Products

- `GET /prodotti` → Retrieve all products
- `GET /prodotti/{id}` → Retrieve a product by ID
- `GET /prodotti/categoria/{categoriaId}` → Retrieve all products by category
- `POST /prodotti` → Create a new product
- `PUT /prodotti/{id}` → Update an existing product
- `DELETE /prodotti/{id}` → Delete a product

### Categories

- `GET /categorie` → Retrieve all categories
- `GET /categorie/{id}` → Retrieve a category by ID
- `POST /categorie` → Create a new category

## Architecture

- Controller layer for REST endpoints
- Service layer for business logic
- Repository layer for database access
- DTOs for request/response separation
- Global exception handling for API errors

## Future Improvements

- JWT authentication
- Swagger/OpenAPI documentation
- Pagination and sorting
- Docker support
- Unit and integration testing
- Role-based authorization
