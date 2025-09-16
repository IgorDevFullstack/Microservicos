# === STAGE 1: build (Maven + JDK) ===
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app

# Copia só o pom para aproveitar cache de dependências
COPY pom.xml .
RUN mvn -q -e -DskipTests dependency:go-offline

# Copia o restante do código e compila
COPY src ./src
RUN mvn -q -DskipTests package

# === STAGE 2: runtime (JRE) ===
FROM eclipse-temurin:17-jre
WORKDIR /app

# Copia o JAR gerado do builder
COPY --from=builder /app/target/*.jar app.jar

# Porta do serviço (alinha com SERVER_PORT=8081 do compose)
EXPOSE 8081

# Healthcheck simples (opcional; ajuste se tiver actuator)
# HEALTHCHECK --interval=30s --timeout=3s --start-period=30s \
#   CMD wget -qO- http://localhost:8081/actuator/health | grep UP || exit 1

# Passa parâmetros do Spring Boot via variáveis de ambiente (vêm do compose)
ENTRYPOINT ["java","-jar","/app/app.jar"]
