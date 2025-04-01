FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app

COPY target/*.jar eureka-service.jar

EXPOSE 8761

ENTRYPOINT ["java", "-jar", "eureka-service.jar"]
