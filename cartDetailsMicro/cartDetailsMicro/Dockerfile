
FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} cartDetailservice.jar
ENTRYPOINT ["java", "-jar", "/cartDetailservice.jar"]
