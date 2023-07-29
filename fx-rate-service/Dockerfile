FROM openjdk:20-oracle
LABEL description="fx-rate-service"
ENV JAVA_OPTS ""
COPY target/fx-rate-service-0.0.1-SNAPSHOT.jar /app/fx-rate-service.jar
VOLUME /app/config /app/log
EXPOSE 8081
CMD java ${JAVA_OPTS} -jar /app/fx-rate-service.jar

# docker build -t fx-rate-service .