FROM eclipse-temurin:17-jdk-alpine

EXPOSE 8080
ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} /app.jar
ENTRYPOINT ["java"]
CMD ["-jar", "/app.jar"]
