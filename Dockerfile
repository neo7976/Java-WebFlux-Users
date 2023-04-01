FROM adoptopenjdk/openjdk11:alpine-jre

VOLUME /tmp

EXPOSE 8080

COPY build/libs/catalizator-0.0.1-SNAPSHOT.jar project-app-by-sobin.jar

#ADD src/main/resources/static/users src/main/resources/static/users

ADD src/main/resources/application.properties src/main/resources/application.properties

CMD ["java", "-jar" ,"project-app-by-sobin.jar"]