FROM ubuntu:latest
LABEL authors="Netgear_2"

FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]