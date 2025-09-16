# === STAGE 1: build (Maven + JDK) ===
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app

# Cache de dependências
COPY pom.xml .
RUN mvn -q -e -DskipTests dependency:go-offline

# Código-fonte e build
COPY src ./src
RUN mvn -q -DskipTests package

# === STAGE 2: runtime (JRE) ===
FROM eclipse-temurin:17-jre
WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

# Porta do serviço (alinha com SERVER_PORT=8082 do compose)
EXPOSE 8082

# HEALTHCHECK opcional (ajuste URL/porta se usar actuator)
# HEALTHCHECK --interval=30s --timeout=3s --start-period=30s \
#   CMD wget -qO- http://localhost:8082/actuator/health | grep UP || exit 1

ENTRYPOINT ["java","-jar","/app/app.jar"]
