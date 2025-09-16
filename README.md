# 🛠️ Microservices Project: Customer & Product

This project demonstrates a **microservices architecture** built with **Java 17 + Spring Boot 3**, **PostgreSQL**, **Docker**, and **Swagger/OpenAPI**.  
The system is composed of two independent services:

- **Customer Service** → Manage customers  
- **Product Service** → Manage products  

Each service has its own database and can be scaled independently.

---

## 🚀 Tech Stack

- Java 17  
- Spring Boot 3.2  
- Spring Data JPA  
- PostgreSQL  
- Docker & Docker Compose  
- Springdoc OpenAPI (Swagger UI)  
- Lombok  
- pgAdmin 4  

---

## 🏗️ Architecture

+------------------+ +-------------------+
| Customer Service| | Product Service |
| (Spring Boot) | | (Spring Boot) |
| Port: 8081 | | Port: 8082 |
+---------+--------+ +---------+---------+
| |
v v
+------------------+ +-------------------+
| PostgreSQL | | PostgreSQL |
| DB: clientedb | | DB: produtodb |
| Port: 5433 | | Port: 5434 |
+------------------+ +-------------------+


---

## 📦 Getting Started

### 1) Requirements
- [Docker](https://www.docker.com/products/docker-desktop) installed and running  
- [Maven](https://maven.apache.org/) (if you want to run locally without Docker)

### 2) Clone the repository
```bash
git clone https://github.com/your-username/Microservices.git
cd Microservices

3) Build and run with Docker

docker compose build
docker compose up -d

4) Check running containers

docker ps

Expected containers:

    customer-service → port 8081

    product-service → port 8082

    postgres-clientes → port 5433

    postgres-produtos → port 5434

    pgadmin → port 5050

📖 API Documentation

Each service exposes its own Swagger/OpenAPI docs:

    Customer Service → http://localhost:8081/swagger-ui.html

Product Service → http://localhost:8082/swagger-ui.html
🧪 Example Requests (cURL)
Create a Customer

curl -X POST http://localhost:8081/customers \
 -H "Content-Type: application/json" \
 -d '{"name":"Maria Silva","email":"maria@email.com","phone":"11999999999"}'

List Customers

curl http://localhost:8081/customers

Create a Product

curl -X POST http://localhost:8082/products \
 -H "Content-Type: application/json" \
 -d '{"name":"Mechanical Keyboard","price":250.0,"description":"Blue switch"}'

List Products

curl http://localhost:8082/products

🗂️ Accessing Database via pgAdmin

    URL: http://localhost:5050

    Login: admin@admin.com

    Password: admin

Add new servers:

    Customer DB

        Host: postgres-clientes

        Port: 5432

        User: postgres

        Password: senha

        Database: clientedb

    Product DB

        Host: postgres-produtos

        Port: 5432

        User: postgres

        Password: senha

        Database: produtodb

✅ Roadmap

Implement pagination and filters in endpoints

Add integration tests with Testcontainers

Add healthchecks in docker-compose.yml

Setup CI/CD with GitHub Actions

Deploy to cloud (AWS/GCP/Azure/Render)