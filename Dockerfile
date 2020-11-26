FROM adoptopenjdk/openjdk11:alpine
WORKDIR /app
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT exec java -Djava.security.egd=file:/dev/urandom $JAVA_OPTS -jar app.jar

#FROM
#RUN addgroup -S spring && adduser -S spring -G spring
#USER spring:spring
#VOLUME /tmp
#ARG JAR_FILE
#ADD ${JAR_FILE} /app/app.jar
#EXPOSE 8080
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/app.jar"]