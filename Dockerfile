FROM openjdk:8-jre-alpine
VOLUME /tmp
COPY target/*.jar app.jar
#COPY target/spring-java-0.0.1-SNAPSHOT.jar app.jar
# Expose port 8080 for the container
EXPOSE 8080
CMD ["java","-jar","app.jar"]