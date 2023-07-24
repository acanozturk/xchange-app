FROM openjdk:20-oracle
LABEL description="discovery-service"
ENV JAVA_OPTS ""
COPY target/discovery-service-0.0.1-SNAPSHOT.jar /app/discovery-service.jar
VOLUME /app/config /app/log
EXPOSE 8761
CMD java ${JAVA_OPTS} -jar /app/discovery-service.jar

# docker build -t discovery-service .