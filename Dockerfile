# Use an official JDK runtime as the base image
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file from the host machine to the container
COPY target/user-0.0.1-SNAPSHOT.jar user.jar

# Expose the port your microservice runs on
EXPOSE 9094

# Command to run the application
ENTRYPOINT ["java", "-jar", "user.jar"]