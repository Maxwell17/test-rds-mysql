# Use an official OpenJDK runtime as a parent image
FROM openjdk:22-ea-jdk-oraclelinux8

# Set the working directory in the container
WORKDIR /app

# Copy the Spring Boot application JAR file into the container
COPY target/test-rds-mysql-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose the port that your Spring Boot application listens on
EXPOSE 8080

# Define the command to run your Spring Boot application
CMD ["java", "-jar", "app.jar"]