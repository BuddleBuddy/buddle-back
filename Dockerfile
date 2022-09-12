FROM openjdk:8-jre
COPY build/libs/buddlebuddy-*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]