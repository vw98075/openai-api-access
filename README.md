

This web application demonstrates the implementation of an OpenAI API messaging tool
using Stomp and Websocket. Its foundation is derived from the Spring guide 
titled "Using WebSocket to build an interactive web application".

This application uses JDK 17, Gradle, one of many OpenAI SDKs on Github, and Spring Boot 3. In order to initiate the program, the user must insert their OpenAI API key 
into the relevant application property file and execute the following command from the root directory of the codebase:
```
./gradlew bootRun
```
After which, the user can proceed to their preferred web browser and navigate to the URL:
```
localhost:8080
```
Here, they will be able to commence a conversation with ChatGPT.
