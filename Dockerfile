FROM eclipse-temurin:11-jdk-alpine AS unpack-jar

WORKDIR /app

COPY target/*.jar .

RUN mkdir -p dependency && (cd dependency; jar -xf ../*.jar)

## --------------------------------

FROM eclipse-temurin:11-jre-alpine

WORKDIR /app

ARG DEPENDENCY=/app/dependency

COPY --from=unpack-jar ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=unpack-jar ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=unpack-jar ${DEPENDENCY}/BOOT-INF/classes /app

ENV CUSTOM_JAVA_OPTS -XshowSettings:vm -XX:+UseContainerSupport -XX:+UseG1GC -XX:+UseStringDeduplication -XX:MaxRAMPercentage=75

ENTRYPOINT ["sh", "-c", "java ${CUSTOM_JAVA_OPTS} ${JAVA_OPTS} -cp /app:/app/lib/* com.bdpz.labs.SpringLabsSolrApplication ${0} ${@}"]
