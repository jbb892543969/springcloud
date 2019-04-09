FROM java:8
ADD ./target/cloud_config-1.0-SNAPSHOT.jar cloud_config-1.0-SNAPSHOT.jar
EXPOSE 10001
ENTRYPOINT ["java", "-jar", "cloud_config-1.0-SNAPSHOT.jar"]
