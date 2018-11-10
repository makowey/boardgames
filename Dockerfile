FROM openjdk:11-jdk-alpine
VOLUME /tmp
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /cheapest-bgg/lib
COPY ${DEPENDENCY}/META-INF /cheapest-bgg/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /cheapest-bgg
ENTRYPOINT ["java","-cp","app:cheapest-bgg/lib/*","info.makowey.boardgames.chilipir.ChilipirApplication"]