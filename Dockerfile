FROM openjdk:21
EXPOSE 8080 8000
ADD target/spring-docker-debugging.jar spring-docker-debugging.jar
ADD entrypoint.sh entrypoint.sh
ENTRYPOINT ["sh", "/entrypoint.sh"]