# com.kooku.Books

## Project Overview

The `com.kooku.Books` project is a Java-based book management system built on Spring Boot. It offers a comprehensive API for managing authors and books, with secure endpoints and a flexible architecture for scalability.

## Project Setup and Configuration

### Prerequisites
- **Java Development Kit (JDK):** Version 8 or higher.
- **Maven:** For managing dependencies and building the project.
- **Database:** Compatible with SQL databases like MySQL, PostgreSQL, etc.
- **IDE:** IntelliJ IDEA, Eclipse, or any preferred Java IDE.

### Setup Guide
1. **Clone/Download Project:**
   - Obtain the source files via Git or direct download.
2. **Database Setup:**
   - Create a new database and configure its connection details in the `application.properties` file.
   - Sample configuration for MySQL:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/books_db
   spring.datasource.username=root
   spring.datasource.password=password
   spring.jpa.hibernate.ddl-auto=update

# Project Documentation

```bash
# Dependencies Installation
# Navigate to the project directory and install dependencies.
mvn clean install

# Running the Project
# Start the application.
mvn spring-boot:run
```

Access the API at http://localhost:8080.

## API Endpoints

### Authentication Endpoints

**POST** `/api/auth/register`  
Registers a new user in the system.

**Required Parameters:**
- `username`: The user's username.
- `password`: The user's password.

**Example Request:**
```json
{
  "username": "new_user",
  "password": "strong_password"
}
```
**POST** `/api/auth/login`  
Authenticates a user and returns a JWT token.

**Required Parameters:**
- `username`: The user's username.
- `password`: The user's password.

**Example Request:**
```json
{
  "username": "john_doe",
  "password": "secure_password"
}

```

## Book API Endpoints

**GET** `/books/allBooks`  
Fetches all books in the system.

**Example Request:**
```json
[
  {
    "Book_ID": 1,
    "title": "Effective Java",
    "Author_ID": 2,
    "ISBN": "1234567890",
    "Description": "A programming guide for Java.",
    "publication_year": 2008
  }
]

```

**GET** `/books/{id}`  
Retrieves a book by its unique ID.

**Path Parameters:**
- id: The book's unique ID.

**Example Request:**
```json
{
  "Book_ID": 1,
  "title": "Effective Java",
  "Author_ID": 2,
  "ISBN": "1234567890",
  "Description": "A programming guide for Java.",
  "publication_year": 2008
}
```
**POST** `/books`  
Adds a new book to the system.

**Required Parameters:**
title: The title of the book.
Author_ID: ID of the author.
ISBN: International Standard Book Number.
Description: A short description of the book.
publication_year: Year of publication.

**Example Request:**
```json
{
  "title": "New Book",
  "Author_ID": 2,
  "ISBN": "0987654321",
  "Description": "A newly published book.",
  "publication_year": 2021
}
```

**PUT** `/books/{id}`  
Updates the information of a book.

**Required Parameters:**
Same as POST /api/books.

**Response:**  JSON object containing the updated book.

**DELETE** `/books/{id}`
Deletes a book by its ID.

**Path Parameter:**

- `id:` The book's unique ID.

**Response:** Confirmation or error message.

## Author API Endpoints


**GET** `/allAuthor`  
Fetches all Authors in the system.

**Example Request:**
```json
[
  {
    "Name": "Author's name."
    "Birth_Year": "Year of birth."
    "biography": "Short biography of the author."
  }
]

```
**GET** `/author/{id}`  
Retrieves a Author by its unique ID.

**Path Parameters:**
- id: The author's unique ID.

**POST** `/author`  
Adds a new author to the system.

**Required Parameters:**
"Name": "Author's name."
"Birth_Year": "Year of birth."
"biography": "Short biography of the author."

**PUT** `/author/{id}`  
Updates the information of a author.

**Required Parameters:**
Same as POST /Books.

**Response:**  JSON object containing the updated author.

**DELETE** `/author/{id}`
Deletes a author by its ID.

**Path Parameter:**

- `id:` The author's unique ID.

**Response:** Confirmation or error message.

 ## Authentication and Authorization
**JWT Authentication:**
 - The application uses JSON Web Tokens (JWT) to secure sensitive endpoints.

- Include the JWT token in the Authorization header with each subsequent request:

http
```
Authorization: Bearer {token}
```
Role-Based Access Control:
The system provides role-based access control through a Role entity and mapping tables. Users are mapped to roles that define their permissions in the system.
