FROM gradle:7.5.1-jdk8-focal AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build

FROM openjdk:8-jre-slim

EXPOSE 8080

RUN mkdir /app

#RUN addgroup -S whatfix && adduser -S whatfix -G whatfix
#USER whatfix:whatfix

COPY --from=build /home/gradle/src/build/libs/*.jar /app/spring-boot-application.jar

ENTRYPOINT ["java","-jar","/app/spring-boot-application.jar"]
