FROM openjdk:11-jre-slim

ENV SPRING_BOOT_HOME=/opt/spring-boot \
    LANG=ja_JP.UTF-8

ARG JAR_FILE=build/libs/backend-0.0.1-SNAPSHOT.jar

WORKDIR /tmp/myspring

COPY ${JAR_FILE} /tmp/myspring/app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/tmp/myspring/app.jar","-verbose:gc"]
