# Customer Management System

The Customer Management System is a Java application built using Maven and the Spring Boot framework. It incorporates Spring Security for JWT authentication to manage customer-related operations securely.

## Table of Contents

- [Frameworks and Language Used](#frameworks-and-language-used)
- [Dataflow](#dataflow)
- [Data Structure](#data-structure)
- [Project Summary](#project-summary)

## Frameworks and Language Used

- Java: The primary programming language used for developing the application.
- Maven: A build automation tool and dependency management tool used for managing the project's dependencies and building the application.
- Spring Boot: A powerful and widely used framework for building Java-based enterprise applications. It provides features like inversion of control, dependency injection, and seamless integration with various other libraries.
- Spring Security: A framework that provides comprehensive security services for Java EE-based enterprise software applications.

## Dataflow

### Entities

I have a `Customer` entity in my project with properties such as `id`, `firstName`, `lastName`, `email`, `password`, etc. Additionally, I have utilized JWT authentication for secure access to customer-related endpoints.

### Controllers

I have implemented controllers for customer operations. The provided APIs include:
1. `POST /api/v1/customer/register`: To register a new customer.
2. `POST /api/v1/customer/login`: To authenticate a customer and generate a JWT token.
3. `GET /api/v1/customer/id/{id}`: To retrieve customer details by ID.
4. `PUT /api/v1/customer/password/id/{id}`: To update the customer's password.
5. `GET /api/v1/customer/all/page`: To retrieve all customers with pagination.
6. `DELETE /api/v1/customer/id/{id}`: To delete a customer.

### Services

The services layer contains business logic for customer-related operations. It acts as an intermediary between the controllers and the repository, encapsulating complex functionalities.

### Repository

The repository layer is responsible for data access and manipulation. It communicates with the database and performs CRUD (Create, Read, Update, Delete) operations on the `Customer` entity.

## Data Structure

I have utilized MySQL as the database to store customer data persistently.

## Project Summary

The Customer Management System is an authenticated system where users can register, log in, and perform various operations related to customers securely. JWT authentication is employed to ensure secure access to customer endpoints. The application provides functionality for registering users, logging in, updating passwords, retrieving customer details, and more.







