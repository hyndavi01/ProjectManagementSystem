FROM openjdk:8
EXPOSE 8086
ADD C:\Users\vhyndavi\Documents\workspace-spring-tool-suite-4-4.14.0.RELEASE\ProjectManagementSystem\build\libs\ProjectManagementSystem-0.0.1-SNAPSHOT.jar ProjectManagementSystem-0.0.1-SNAPSHOT
ENTRYPOINT [ "java", "-jar", "\ProjectManagementSystem-0.0.1-SNAPSHOT.jar" ]