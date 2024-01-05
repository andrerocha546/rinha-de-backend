FROM gradle:8.5-jdk17-alpine AS BUILD_API
WORKDIR /app/
COPY . .
RUN gradle build


FROM openjdk:17-alpine

ENV HOME_DIR=/app/
ENV JAR_FILE=$HOME_DIR/build/libs/rinha-de-backend-0.0.1-SNAPSHOT.jar

WORKDIR $HOME_DIR

COPY --from=BUILD_API ${JAR_FILE} api.jar

EXPOSE 8080

CMD ["java", "-jar", "api.jar"]