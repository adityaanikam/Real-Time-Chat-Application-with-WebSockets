# Use OpenJDK 17 as base image
FROM openjdk:17-jdk-slim

# Set working directory in container
WORKDIR /app

# Copy Maven wrapper and pom.xml first for better Docker layer caching
COPY mvnw ./
COPY mvnw.cmd ./
COPY .mvn .mvn
COPY pom.xml ./

# Download dependencies (this layer will be cached if pom.xml doesn't change)
RUN chmod +x mvnw && ./mvnw dependency:go-offline -B

# Copy source code
COPY src ./src

# Build the application
RUN ./mvnw clean package -DskipTests

# Expose port that the app runs on
EXPOSE 8080

# Create directory for SQLite database
RUN mkdir -p /app/data

# Set environment variables
ENV SPRING_PROFILES_ACTIVE=prod
ENV SPRING_DATASOURCE_URL=jdbc:sqlite:/app/data/chat.db

# Run the application
CMD ["java", "-jar", "target/Real-Time-Chat-Application-with-WebSockets-0.0.1-SNAPSHOT.jar"] 