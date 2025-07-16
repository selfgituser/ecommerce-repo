
FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ecomeurekaservice.jar
ENTRYPOINT ["java", "-jar", "/ecomeurekaservice.jar"]
