#FROM openjdk:8-jdk-alpine
#FROM openjdk:17-jdk-alpine
#FROM adoptopenjdk/openjdk11:alpine-jre
FROM openjdk:17-jdk-alpine
ADD target/spring-cache-redis-api-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
