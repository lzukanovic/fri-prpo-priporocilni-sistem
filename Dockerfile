FROM openjdk:11.0.5-jre-slim

RUN mkdir /app

WORKDIR /app

#ADD ./api/target/api-RELEASE-0.1.jar /app
ADD ./api/target/ /app

EXPOSE 8081

#CMD java -jar api-RELEASE-0.1.jar
CMD java -cp classes:dependency/* com.kumuluz.ee.EeApplication

