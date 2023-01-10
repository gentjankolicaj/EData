FROM amazoncorretto:11

WORKDIR /app

COPY ./target/extract-service-1.0-SNAPSHOT-jar-with-dependencies.jar /app/app.jar

EXPOSE 8080

CMD ["java","-jar","app.jar"]