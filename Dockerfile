FROM java:8
EXPOSE 8080
ADD pixogram.jar pixogram.jar
ENTRYPOINT ["java", "-jar", "pixogram.jar"]