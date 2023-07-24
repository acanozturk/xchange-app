FROM openjdk:20-oracle
LABEL description="gateway-service"
ENV JAVA_OPTS ""
COPY target/gateway-service-0.0.1-SNAPSHOT.jar /app/gateway-service.jar
VOLUME /app/config /app/log
EXPOSE 8761
CMD java ${JAVA_OPTS} -jar /app/gateway-service.jar

# docker build -t gateway-service .