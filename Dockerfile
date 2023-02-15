###############################################################################
## first stage, build the source code with java 8
###############################################################################
FROM maven:3.8.6-amazoncorretto-19 AS MAVEN_BUILD



# copy the pom and source code to the container
RUN mkdir /sources

COPY ./ /sources

RUN echo "Building API..." && cd /sources && mvn clean package

###############################################################################
## second stage, run the code with java 10
###############################################################################
#Coretto

FROM amazoncorretto:19

LABEL \
  maintainer="Javier Charry <javier.charry@outlook.com>" \
  application="BESTORE-API"

# copy only the artifacts we need from the first stage and discard the rest
COPY --from=MAVEN_BUILD /sources/target/Bestore*.jar /app/bestore-api.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app/bestore-api.jar"]