FROM openjdk:21-jdk

WORKDIR /app

COPY target/*.jar user-service.jar

EXPOSE 9090

ENTRYPOINT ["java", "-jar", "user-service.jar"]
