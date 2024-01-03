FROM openjdk:17-alpine

ARG JAR_FILE=build/libs/rinha-de-backend-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} /app/api.jar

WORKDIR /app

EXPOSE 8080

CMD ["java", "-jar", "api.jar"]
