# Customer Rewards Program API

A Spring Boot REST API that calculates customer rewards points based on their purchase transactions.

## Overview

This application implements a retailer's rewards program where customers earn points based on their purchase amounts:
- 2 points for every dollar spent over $100
- 1 point for every dollar spent between $50 and $100

For example, a $120 purchase earns: (2 × $20) + (1 × $50) = 90 points

## Technical Stack

- Java 17
- Spring Boot 3.7
- Spring Data JPA
- H2 Database
- Lombok
- JUnit

## API Endpoints

### Get All Customer Rewards
GET /customer-rewards

### Error Responses

```json
{
    "details": "uri=/customer-rewards",
    "message": "org.hibernate.query.sqm.UnknownEntityException: Could not resolve root entity 'Transaction'",
    "timestamp": "2025-02-03T12:24:26.811+00:00",
    "status": 500
}
```

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/example/rewardportalproject/
│   │       ├── controllers/
│   │       ├── entities/
│   │       ├── exceptions/
│   │       ├── repository/
│   │       └── services/
│   └── resources/
│       ├── application.properties
│       ├── data.sql
│       └── schema.sql
└── test/
    └── java/
        └── com/example/rewardportalproject/
            ├── controllers/
            └── services/
```

## Getting Started

1. Clone the repository
2. Run using Maven:
   ```bash
   ./mvnw spring-boot:run
   ```
3. Access the API at http://localhost:8080/customer-rewards

## Development

The application uses an H2 in-memory database with sample data loaded at startup. The database console is available at http://localhost:8080/h2-console.


