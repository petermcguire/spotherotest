FROM adoptopenjdk/openjdk11:ubi
WORKDIR /app
EXPOSE 3000
ADD ./build/libs/spotherotest-0.0.1-SNAPSHOT.jar .
CMD ["java", "-jar", "spotherotest-0.0.1-SNAPSHOT.jar"]