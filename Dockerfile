# define base docker image
FROM openjdk:8
LABEL maintainer="madycisko.net"
ADD target/budget-expenses-tracker-0.0.1-SNAPSHOT.jar budget-expenses-tracker.jar
ENTRYPOINT ["java", "-jar", "budget-expenses-tracker.jar"]