FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} produto-api.jar
ENTRYPOINT ["java", "-jar", "/produto-api.jar"]