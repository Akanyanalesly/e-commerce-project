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
  "id": 3,
  "name": "iPhone 15 Pro",
  "description": "Latest Apple smartphone with A17 chip",
  "price": 999.99,
  "category": "Mobile Phones",
  "stockQuantity": 25,
  "brand": "Apple"
},

```

## Ihave use Post Method to add atleast 3 Products.


<img width="352" height="349" alt="Image" src="https://github.com/user-attachments/assets/f2e5a692-5988-44e8-a7a3-9977ba1c7603" />


#### Get All Products
**GET** `/api/products`

## I used the Get Method like (http://localhost:8080/api/products) to retrieve all products 

<img width="346" height="392" alt="Image" src="https://github.com/user-attachments/assets/4f2353de-9c83-4c34-b169-712b38ad2695" />


<img width="358" height="313" alt="Image" src="https://github.com/user-attachments/assets/7357a4d7-4fe2-4b99-a535-75a30040771f" />


<img width="341" height="395" alt="Image" src="https://github.com/user-attachments/assets/35b9edda-a948-4d53-a525-5eadc6896f7e" />


#### Get Product by ID
**GET** `/api/products/{id}`

## By using(http://localhost:8080/api/products/3) to get the product of the ID i want


<img width="358" height="358" alt="Image" src="https://github.com/user-attachments/assets/33369793-2397-4eef-a399-cfe343cf7a89" />



#### Update Product
**PUT** `/api/products/{id}`
```json
 {
        "brand": "Nike",
        "category": "Footwear",
        "description": "Running shoes with air cushioning",
        "id": 5,
        "name": "Nike Air Max",
        "price": 129.99,
        "stockQuantity": 50
    }
```

#### By using PUT method I was able to update stockquantoty of Nike Air Max from 40 to 50, using (http://localhost:8080/api/products/5)



<img width="353" height="326" alt="Image" src="https://github.com/user-attachments/assets/93752838-8158-45c0-88e0-201258a9a33d" />


#### Delete Product
**DELETE** `/api/products/{id}`

##Using (http://localhost:8080/api/products/6) i was able to delete this product


<img width="338" height="359" alt="Image" src="https://github.com/user-attachments/assets/d46b05a2-cdd6-42f2-a039-089ba15d1f0a" />



## Running the Application
```bash
mvn spring-boot:run
```

Server runs on: `http://localhost:8080`



https://github.com/Akanyanalesly/Spring-boot-projects/tree/restFull_api_26594

https://github.com/Akanyanalesly/e-commerce-project
