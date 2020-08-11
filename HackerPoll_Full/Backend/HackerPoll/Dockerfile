FROM openjdk:8 

WORKDIR /usr/local/lib

COPY ./target/Postman.jar Postman.jar

EXPOSE 80

CMD [ "java","-jar","/usr/local/lib/Postman.jar","--spring.data.mongodb.host=db"]
