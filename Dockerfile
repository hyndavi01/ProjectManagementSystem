FROM openjdk:8
WORKDIR /app
ADD build\libs\ProjectManagementSystem-0.0.1-SNAPSHOT.jar .
EXPOSE 8087
ENTRYPOINT [ "java", "-jar", "ProjectManagementSystem-0.0.1-SNAPSHOT.jar" ]