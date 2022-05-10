FROM adoptopenjdk/openjdk11:alpine-jre
VOLUME /tmp
EXPOSE 8082
ADD build/libs/PropertyManagementSystem-1-0.0.1-SNAPSHOT.jar  app.jar
ENTRYPOINT [ "sh", "-c", "java -jar /app.jar" ]