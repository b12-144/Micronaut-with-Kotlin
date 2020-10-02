FROM openjdk:14-alpine
COPY build/libs/bootstrap-*-all.jar bootstrap.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "jibDockerBuild-jar", "bootstrap.jar"]
