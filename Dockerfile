FROM openjdk:11-jre-slim
WORKDIR /app
COPY target/test_ExchangerParser-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]