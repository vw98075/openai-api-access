# ChatGPT Spring Boot Web Application with Stomp and Websocket

This web application demonstrates the implementation of an OpenAI API messaging tool using Stomp and Websocket. Its 
foundation is derived from the Spring guide titled "Using WebSocket to build an interactive web application".

JDK 17 and Gradle are needed to build this web application. In order to connect with OpenAI APIs, an OpenAI API key need 
to be placed into the application property file. To start this web application, execute the following command from the 
root directory of the codebase:
```
./gradlew bootRun
```
After which, the user can proceed to their preferred web browser and navigate to the URL:
```
localhost:8080
```
Here, they will be able to commence a conversation with ChatGPT.
