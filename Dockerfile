# Build Stage
FROM maven:3.8.5-openjdk-17 AS build

COPY . .
RUN mvn clean package -DskipTests

# Runtime Stage
FROM openjdk:17.0.1-jdk-slim

COPY --from=build /app/target/task-manager-0.0.1-SNAPSHOT.jar task-manager.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "task-manager.jar"]
