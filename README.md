🧩 Microservices Architecture — Customer & Product

Este projeto demonstra uma arquitetura completa de microsserviços, utilizando Java 17 + Spring Boot 3, PostgreSQL, Docker, Swagger/OpenAPI e práticas modernas de desenvolvimento backend.

A aplicação é composta por dois serviços independentes, cada um com seu próprio banco de dados:

🧍 Customer Service — Gestão de clientes

📦 Product Service — Gestão de produtos

Cada serviço é isolado, escalável e versionável de forma independente.

🚀 Tecnologias Utilizadas

Back-end

Java 17

Spring Boot 3.x

Spring Web

Spring Data JPA

Spring Validation

Swagger / OpenAPI 3

Lombok

Banco & Infra

PostgreSQL

Docker & Docker Compose

pgAdmin 4

🏛️ Arquitetura

                +----------------------+
                |   Customer Service   |
                |   Port: 8081         |
                +---------+------------+
                          |
                          v
                +----------------------+
                |   PostgreSQL         |
                |   DB: clientedb      |
                +----------------------+

                +----------------------+
                |   Product Service    |
                |   Port: 8082         |
                +---------+------------+
                          |
                          v
                +----------------------+
                |   PostgreSQL         |
                |   DB: produtodb      |
                +----------------------+
Cada microsserviço possui:
✔ Seu próprio banco
✔ Seu próprio container
✔ Suas próprias rotas e documentação

📦 Como Executar o Projeto
1️⃣ Pré-requisitos

Docker instalado

Docker Compose

Git

(Opcional) Maven, caso queira rodar fora do Docker

2️⃣ Clonar o repositório

git clone https://github.com/your-username/microservices.git
cd microservices

3️⃣ Subir tudo com Docker 🐳

docker compose build
docker compose up -d

4️⃣ Verificar containers ativos

docker ps

| Serviço           | Porta |
| ----------------- | ----- |
| customer-service  | 8081  |
| product-service   | 8082  |
| postgres-clientes | 5433  |
| postgres-produtos | 5434  |
| pgadmin           | 5050  |

📚 Documentação das APIs (Swagger)

| Serviço      | URL                                                                            |
| ------------ | ------------------------------------------------------------------------------ |
| **Customer** | [http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html) |
| **Product**  | [http://localhost:8082/swagger-ui.html](http://localhost:8082/swagger-ui.html) |

🧪 Exemplos de Requisições (cURL)

curl -X POST http://localhost:8081/customers \
-H "Content-Type: application/json" \
-d '{"name":"Maria Silva","email":"maria@email.com","phone":"11999999999"}'


📄 Listar Produtos

curl http://localhost:8082/products


🗂️ Acessar banco pelo pgAdmin

📌 URL: http://localhost:5050
📌 Login: admin@admin.com
📌 Senha: admin

Depois registre os servidores:

🔹 Customer DB

Host: postgres-clientes

Port: 5432

User: postgres

Password: senha

Database: clientedb

🔹 Product DB

Host: postgres-produtos

Port: 5432

User: postgres

Password: senha

Database: produtodb

🛠️ Roadmap de Evolução

Paginação e filtros avançados
Testes automatizados com Testcontainers
Healthchecks no docker-compose.yml
CI/CD com GitHub Actions
Deploy em cloud (AWS, Render, Railway etc.)
Service Discovery + API Gateway (Eureka/Cloud Gateway).

Status do Projeto

📌 Em desenvolvimento ativo
📌 Arquitetura escalável, ideal para vagas de backend e sistemas distribuídos
