FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app

COPY target/*.jar config-service.jar

EXPOSE 8888

ENTRYPOINT ["java", "-jar", "config-service.jar"]
