FROM openjdk:11

WORKDIR /app
COPY target/template.jar /app/template.jar

CMD ["java", "-jar", "/app/template.jar"]
