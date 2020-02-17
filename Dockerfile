FROM openjdk:11-jdk-buster

ARG file_name

RUN mkdir /opt/app
COPY target/$file_name.jar /opt/app/app.jar
ENTRYPOINT ["java","-jar", "-Dspring.profiles.active=prod", "/opt/app/app.jar"]