# Shop API - Spring Boot REST API

REST API developed with Java and Spring Boot for managing products and categories.

The project was created as a backend training project to practice REST API design, layered architecture, JPA relationships, DTOs, validation, exception handling and Swagger documentation.

## Technologies

* Java 17
* Spring Boot
* Spring Web MVC
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* Jakarta Validation
* Swagger / OpenAPI
* Postman
* Git & GitHub

## Features

* CRUD operations for products
* CRUD operations for categories
* Product-category relationship with JPA
* Request and response DTOs
* Input validation
* Centralized exception handling
* Custom error responses
* Swagger/OpenAPI documentation

## Architecture

The project follows a layered architecture:

* Controller
* Service
* Repository
* DTO
* Entity
* Exception handling

## API Endpoints

### Products

| Method | Endpoint                            | Description              |
| ------ | ----------------------------------- | ------------------------ |
| GET    | `/prodotti`                         | Get all products         |
| GET    | `/prodotti/{id}`                    | Get product by ID        |
| GET    | `/prodotti/categoria/{categoriaId}` | Get products by category |
| POST   | `/prodotti`                         | Create product           |
| PUT    | `/prodotti/{id}`                    | Update product           |
| DELETE | `/prodotti/{id}`                    | Delete product           |

### Categories

| Method | Endpoint          | Description        |
| ------ | ----------------- | ------------------ |
| GET    | `/categorie`      | Get all categories |
| GET    | `/categorie/{id}` | Get category by ID |
| POST   | `/categorie`      | Create category    |
| PUT    | `/categorie/{id}` | Update category    |
| DELETE | `/categorie/{id}` | Delete category    |

## Example Product Request

```json
{
  "nome": "Mouse Gaming",
  "prezzo": 49.99,
  "categoriaId": 1
}
```

## Example Product Response

```json
{
  "id": 1,
  "nome": "Mouse Gaming",
  "prezzo": 49.99,
  "categoriaNome": "Informatica"
}
```

## Error Response Example

```json
{
  "messaggioErrore": "nome: Il nome del prodotto è obbligatorio",
  "status": 400
}
```

## Swagger Documentation

Swagger UI is available at:

```text
http://localhost:8080/swagger-ui/index.html
```

## How to Run

Requirements:

* Java 17
* Maven
* MySQL

Run the application:

```bash
mvn spring-boot:run
```

The API will be available at:

```text
http://localhost:8080
```

## Future Improvements

* Unit tests
* Integration tests
* Pagination and sorting
* Spring Security
* JWT authentication
* Docker support

## Author

Developed by Eros Pezzatini.

GitHub: `github.com/docpezza`
