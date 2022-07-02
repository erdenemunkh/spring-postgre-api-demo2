# Multi Stage build

# Base Image and name stage as "builder"
FROM maven:3-openjdk-15 AS builder

# Create App Directory inside our container
WORKDIR /demo2

# Copy files
COPY . .

RUN mvn -f /demo2/pom.xml clean package -DskipTests

#### 2nd Stage ####

FROM openjdk:15.0.1

WORKDIR /lib/

# Copy the Jar from the first Stage (builder) to the 2nd stage working directory
COPY --from=builder /demo2/target/demo2-0.0.1-SNAPSHOT.jar ./dockerized.jar

# Expose the port to the inner container communication network
EXPOSE 8080

# Run the Java Application
ENTRYPOINT [ "java","-jar","/lib/dockerized.jar"]