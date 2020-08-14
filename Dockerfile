FROM openjdk:8
MAINTAINER mdiaby00@gmail.com
EXPOSE 9090
COPY target/book-store.jar book-store.jar
ENTRYPOINT  ["java","-jar","/book-store.jar"]
