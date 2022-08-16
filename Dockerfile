FROM openjdk:17

WORKDIR /opt/app

ENV SERVER_PORT 8080

EXPOSE $SERVER_PORT

ARG JAR_FILE=target/CalculatorCaseStudy.jar
ARG PROP_FILE=src/main/resources/application.yaml

COPY ${JAR_FILE} app/CalculatorCaseStudy.jar
COPY ${PROP_FILE} app/application.yaml

ENTRYPOINT ["java","-jar","app/CalculatorCaseStudy.jar"]