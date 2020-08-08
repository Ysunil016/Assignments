FROM openjdk:8 

WORKDIR /usr/local/lib

COPY ./target/OrderManagement.jar OrderManagement.jar

EXPOSE 8000

CMD [ "java","-jar","/usr/local/lib/OrderManagement.jar","--spring.data.mongodb.host=db"]
