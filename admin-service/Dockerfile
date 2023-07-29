FROM openjdk:20-oracle
LABEL description="admin-service"
ENV JAVA_OPTS ""
COPY target/admin-service-0.0.1-SNAPSHOT.jar /app/admin-service.jar
VOLUME /app/config /app/log
EXPOSE 8000
CMD java ${JAVA_OPTS} -jar /app/admin-service.jar

# docker build -t admin-service .