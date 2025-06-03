FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh

COPY target/*.jar app.jar

ENTRYPOINT ["./wait-for-it.sh", "db:5432", "--", "java", "-jar", "app.jar"]
