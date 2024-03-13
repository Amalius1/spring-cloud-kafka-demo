# Use OpenJDK 17 as base
FROM openjdk:17-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the pre-built jar file into the Docker image
COPY /build/libs/kafka-sync-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose the application on port 8080
EXPOSE 8080

# Set the startup command to execute the jar
ENTRYPOINT ["java","-jar","/app/app.jar"]