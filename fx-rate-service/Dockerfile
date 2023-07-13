FROM openjdk:19-oracle

LABEL description="FX Rate Service"

ENV JAVA_OPTS ""

COPY target/fxRateService-0.0.1-SNAPSHOT.jar /app/fxRateService.jar

VOLUME /app/config /app/log

EXPOSE 8080

CMD java ${JAVA_OPTS} -jar /app/fxRateService.jar