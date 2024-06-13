# Portfolio - Ecommerce Backend

This project involves the development of a backend with microservices architecture for an ecommerce platform. The main services are Carts, Products, and Sales.

## Technologies Used

- **Java**: Programming language used for development.
- **Spring Boot**: Application framework used to facilitate Java application development.
- **Spring Cloud**: Toolkit for building distributed systems.
- **Feign**: HTTP client for simplifying communication with RESTful services.
- **Eureka Server**: Implementation of Service Registry and Service Discovery for microservices architecture.
- **Spring Cloud Load Balancer**: For load balancing.
- **Resilience4J**: Library for implementing resilience patterns, such as Circuit Breaker.

## Functionality

### Product Service
The Product service manages information about appliances available on the platform. It provides operations to list products and obtain details such as code, name, brand, and individual price.

### Cart Service
The Cart service handles users' shopping carts. It allows users to add and remove items from the cart. Each cart has a unique identifier (ID) and a field to store the total price of the products in it.

### Sale Service
The Sale service records each sale with an identification number and a date. Each sale is associated with a shopping cart. When saving a sale, a cart is assigned, and the total sale amount is obtained by querying the shopping cart and the list of products by consulting the cart service, which in turn consumes the product service.

This project implements a robust architecture to support the operations of an ecommerce platform, ensuring availability and reliability of services through the implementation of design patterns and resilience techniques.
