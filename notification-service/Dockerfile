FROM openjdk:20-oracle
LABEL description="notification-service"
ENV JAVA_OPTS ""
COPY target/notification-service-0.0.1-SNAPSHOT.jar /app/notification-service.jar
VOLUME /app/config /app/log
EXPOSE 8100
CMD java ${JAVA_OPTS} -jar /app/notification-service.jar

# docker build -t notification-service .