# E-Commerce REST API

A Spring Boot REST API for managing products in an e-commerce system.

## Technologies
- Spring Boot
- PostgreSQL
- JPA/Hibernate

## Database Configuration
```properties
Database: ecommerce_db
Port: 5432
Username: postgres
Password: 123
```

## API Endpoints

### CRUD Operations

#### Create Product
**POST** `/api/products/addProduct`
```json
{
  "id": 1,
  "name": "Laptop",
  "description": "Gaming laptop",
  "price": 1200.00,
  "category": "Electronics",
  "stockQuantity": 10,
  "brand": "Dell"
}
```

#### Get All Products
**GET** `/api/products`

#### Get Product by ID
**GET** `/api/products/{id}`

Example: `/api/products/1`

#### Update Product
**PUT** `/api/products/{id}`
```json
{
  "name": "Gaming Laptop",
  "description": "High-end gaming laptop",
  "price": 1500.00,
  "category": "Electronics",
  "stockQuantity": 5,
  "brand": "Dell"
}
```

#### Delete Product
**DELETE** `/api/products/{id}`

Example: `/api/products/1`

### Search Operations

#### Search by Category
**GET** `/api/products/search?category=Electronics`

#### Search by Brand
**GET** `/api/products/brand/Dell`

#### Search by Price Less Than
**GET** `/api/products/price/less-than/500`

#### Search by Price Range
**GET** `/api/products/price/between/100/1000`

## Running the Application
```bash
mvn spring-boot:run
```

Server runs on: `http://localhost:8080`



https://github.com/Akanyanalesly/Spring-boot-projects/tree/restFull_api_26594

https://github.com/Akanyanalesly/e-commerce-project
