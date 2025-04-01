# Больше не нужен Maven внутри Docker
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY target/*.jar user-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "user-service.jar"]
