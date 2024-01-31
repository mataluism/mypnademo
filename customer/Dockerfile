FROM openjdk:17-jdk-slim
COPY ./target/customer-service-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
EXPOSE 8092
ENTRYPOINT ["java", "-jar", "customer-service-0.0.1-SNAPSHOT.jar"]