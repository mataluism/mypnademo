FROM openjdk:17-jdk-slim
COPY ./target/account-service-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
EXPOSE 8091
ENTRYPOINT ["java", "-jar", "account-service-0.0.1-SNAPSHOT.jar"]