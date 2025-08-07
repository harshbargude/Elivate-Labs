# Library Management System (Spring Boot + Thymeleaf + AJAX)

A web-based library management system built with Spring Boot, Thymeleaf, and AJAX, implementing OOP principles.

## Features
- View/add books and users via a web UI.
- Issue and return books dynamically using AJAX.
- Reusable Thymeleaf fragments for navigation and tables.
- In-memory H2 database for storing books and users.

## Technologies
- Java, Spring Boot, Thymeleaf, Spring Data JPA, H2 Database
- jQuery (for AJAX), CSS
- Maven, VS Code

## How to Run
1. Clone this repository.
2. Run `mvn spring-boot:run`.
3. Open `http://localhost:8080` in a browser.
4. Access the H2 console at `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:librarydb`).

## OOP Concepts Used
- **Encapsulation**: Private fields with getters/setters in `Book` and `User`.
- **Abstraction**: `LibraryService` hides business logic.
- **Polymorphism**: Overriding `toString()` in models.

## Notes
- AJAX is used for issuing/returning books and refreshing the book list.
- Thymeleaf fragments modularize the UI (navbar, book/user tables).
- Data is stored in an in-memory H2 database.

## Screenshots
[Add screenshots of the UI, e.g., books page with updated list, issue form with AJAX response]