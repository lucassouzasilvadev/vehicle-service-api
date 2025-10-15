FROM openjdk:17-jdk-slim

LABEL maintainer="Auto Sale Team <dev@autosale.com>"
WORKDIR /app

COPY target/auto-sale-*.jar app.jar

ENV SPRING_PROFILES_ACTIVE=prod
ENV JAVA_OPTS="-Xms512m -Xmx1024m"

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
