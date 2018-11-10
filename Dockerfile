FROM openjdk:11
COPY /home/gamer/boardgames/target/cheapest-bgg.jar /home/gamer/
WORKDIR /home/gamer/
RUN java -jar cheapest-bgg.jar