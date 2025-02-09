# Use Maven with OpenJDK 8 for building the application
FROM maven:3.8.6-openjdk-8 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project files
COPY pom.xml .

# Download dependencies first (to cache them)
RUN mvn dependency:go-offline -B

# Copy the source code
COPY src ./src

# Build the application (skip tests for faster builds)
RUN mvn clean package -DskipTests

# Use OpenJDK 8 for running the application
FROM openjdk:8-jdk-alpine

# Set the working directory for the runtime stage
WORKDIR /app

# Copy the built JAR file from the previous stage
COPY --from=build /app/target/*.jar app.jar

# Expose the application port (Spring Boot default is 8080)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
