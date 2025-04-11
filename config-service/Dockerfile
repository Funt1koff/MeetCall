FROM openjdk:21-jdk
WORKDIR /app

COPY target/*.jar config-service.jar

EXPOSE 8888

ENTRYPOINT ["java", "-jar", "config-service.jar"]
