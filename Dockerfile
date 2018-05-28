FROM openjdk:8-jdk-alpine
RUN  apk update && apk upgrade
RUN mkdir -p /usr/local/tours
ADD demo-0.0.1-SNAPSHOT.jar /usr/local/tours/
CMD java -jar /usr/local/tours/demo-0.0.1-SNAPSHOT.jar