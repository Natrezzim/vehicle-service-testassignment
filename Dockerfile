FROM adoptopenjdk/openjdk11
ARG JAR_FILE=build/libs/vehicle-service-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} vehserv.jar
ENTRYPOINT ["java","-jar","/vehserv.jar"]