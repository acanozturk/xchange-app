FROM openjdk:20-oracle
LABEL description="config-service"
ENV JAVA_OPTS ""
COPY target/config-service-0.0.1-SNAPSHOT.jar /app/config-service.jar
VOLUME /app/config /app/log
EXPOSE 8888
CMD java ${JAVA_OPTS} -jar /app/config-service.jar

# docker build -t config-service .