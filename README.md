whereisISS-spring-websockets project.
====================

Sample application demoing Spring Websocket support with spring integration and rabbitmq with stomp support


This is a simple application that uses Spring 4 websockets support to show where the ISS is flying now.

The data is sourced from wheretheiss.at program using his api. Spring Integration is used for polling for this information and
storing this in RabbitMQ.

Spring WebSockets support with STOMP protocol integrating with RabbitMQ is used for showing realtime information on UI.

Spring Boot is used for packaging the entire application

To run the application, first set up rabbitmq and add in the stomp plugin

Application can then be started up using the following command:

mvn spring-boot:run

Probably you are going to need import the cert file from https server, 
see http://www.mkyong.com/webservices/jax-ws/suncertpathbuilderexception-unable-to-find-valid-certification-path-to-requested-target/

