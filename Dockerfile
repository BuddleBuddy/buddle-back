FROM openjdk:11-jdk
COPY build/libs/buddlebuddy-*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]