FROM openjdk:17-jdk-slim
COPY ./target/eureka-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "eureka-0.0.1-SNAPSHOT.jar"]