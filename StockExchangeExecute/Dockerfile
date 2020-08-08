FROM openjdk:8 

WORKDIR /usr/local/lib

COPY ./target/Executor.jar Executor.jar

EXPOSE 8001

CMD [ "java","-jar","/usr/local/lib/Executor.jar","--spring.data.mongodb.host=db"]
