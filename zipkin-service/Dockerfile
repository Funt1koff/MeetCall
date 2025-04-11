FROM openjdk:21-jdk

WORKDIR /app

EXPOSE 9411

COPY target/*.jar zipkin-service.jar

ENTRYPOINT ["java", "-jar", "zipkin-service.jar"]
