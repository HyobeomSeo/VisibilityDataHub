FROM openjdk:17-jdk-alpine
COPY target/datahub-0.0.1-SNAPSHOT.jar /app/datahub-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "/app/datahub-0.0.1-SNAPSHOT.jar"]