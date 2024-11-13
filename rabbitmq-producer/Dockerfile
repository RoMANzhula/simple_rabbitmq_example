# Stage 1: Build
FROM openjdk:22-jdk-slim AS build

# Install Maven
RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*

# Copy project
COPY src /src
COPY pom.xml /
# Build project without tests
RUN mvn -f /pom.xml clean package -DskipTests=true

# Stage 2: Runtime
FROM openjdk:22-jdk-slim
COPY --from=build /target/rabbitmq-producer-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

