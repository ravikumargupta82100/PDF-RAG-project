FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]

FROM jenkins/jenkins:lts-jdk21

USER root

RUN apt-get update && apt-get install -y \
    docker.io \
    git \
    curl

USER jenkins