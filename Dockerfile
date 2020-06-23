FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/
COPY ${JAR_FILE} user-service.jar
ENTRYPOINT ["java","-jar","/user-service.jar"]