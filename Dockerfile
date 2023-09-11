FROM openjdk:17.0.2-jdk-slim-buster

EXPOSE 8080

ADD target/authorization-service-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]