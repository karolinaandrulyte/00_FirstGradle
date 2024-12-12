FROM openjdk:17
WORKDIR /app
COPY build/libs/00_FirstGradle-1.0-SNAPSHOT.jar /app/00_FirstGradle-1.0-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/app/00_FirstGradle-1.0-SNAPSHOT.jar"]