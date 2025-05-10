🧩 Projeto de Microserviços: Cliente e Produto

Este projeto é um sistema básico composto por dois microserviços independentes: Cliente Service e Produto Service. Ambos são desenvolvidos com Spring Boot, Java 17, PostgreSQL e Docker para facilitar o desenvolvimento e a escalabilidade.

📦 Tecnologias Utilizadas

    Java 17

    Spring Boot 3.2

    Spring Data JPA

    PostgreSQL

    Docker

    Maven

    Lombok
    

📁 Estrutura dos Microserviços

🔹 cliente-service

Responsável por gerenciar os dados dos clientes.

Endpoints:
Método	Rota	Descrição
POST	/clientes	Criar novo cliente
GET	/clientes	Listar todos os clientes
GET	/clientes/{id}	Buscar cliente por ID
PUT	/clientes/{id}	Atualizar cliente
DELETE	/clientes/{id}	Remover cliente

🔹 produto-service

Responsável por gerenciar os dados dos produtos.

Endpoints:
Método	Rota	Descrição
POST	/produtos	Criar novo produto
GET	/produtos	Listar todos os produtos
GET	/produtos/{id}	Buscar produto por ID
PUT	/produtos/{id}	Atualizar produto
DELETE	/produtos/{id}	Remover produto

⚙️ Como Executar

    Criar os bancos no PostgreSQL:

        Acesse o PgAdmin ou o terminal:

CREATE DATABASE clientedb;
CREATE DATABASE produtodb;

Editar application.properties de cada serviço:

Exemplo cliente-service:

spring.datasource.url=jdbc:postgresql://localhost:5432/clientedb
spring.datasource.username=postgres
spring.datasource.password=senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
server.port=8081

Exemplo produto-service:

spring.datasource.url=jdbc:postgresql://localhost:5432/produtodb
spring.datasource.username=postgres
spring.datasource.password=senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
server.port=8082

Executar os microserviços:

    mvn spring-boot:run

🧪 Testando os serviços

Use o Postman ou o curl para testar os endpoints:

# Exemplo: Cadastrar um cliente
curl -X POST http://localhost:8081/clientes \
-H "Content-Type: application/json" \
-d '{"nome":"Maria","email":"maria@email.com","telefone":"119999999"}'

🚀 Futuras Implementações

    Integração entre serviços com Spring Cloud / Eureka

    Autenticação com JWT

  
