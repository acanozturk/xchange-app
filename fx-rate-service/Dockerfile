FROM openjdk:20-oracle
LABEL description="FX Rate Service"
ENV JAVA_OPTS ""
COPY target/fx-rate-service-0.0.1-SNAPSHOT.jar /app/fx-rate-service.jar
VOLUME /app/config /app/log
EXPOSE 8080
CMD java ${JAVA_OPTS} -jar /app/fx-rate-service.jar