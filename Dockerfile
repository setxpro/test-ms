FROM ubuntu:latest AS build
LABEL authors="PATRICK-ANJOS"

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .

RUN apt-get install maven -y

RUN mvn clean install

FROM openjdk:17-jdk-slim

EXPOSE 8881

COPY --from=build /target/ms1-0.0.1-SNAPSHOT.jar app_mst.jar

ENTRYPOINT [ "java", "-jar", "app_mst.jar" ]