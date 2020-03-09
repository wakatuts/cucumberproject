FROM openjdk:8-jdk-slim
WORKDIR /usr/share/tag
ADD target/selenium-container.jar selenium-container.jar
ADD target/libs libs
ENTRYPOINT java -cp selenium-container.jar:libs/* -DseleniumHubHost=localhost -Dbrowser=chrome
