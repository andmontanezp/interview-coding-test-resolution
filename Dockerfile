FROM openjdk:8-jdk-alpine as BUILD

COPY *.gradle gradle.* gradlew /src/
COPY gradle /src/gradle

WORKDIR /src

RUN ./gradlew --version

COPY . .

RUN ./gradlew test

RUN ./gradlew jar

#Stage 2
FROM openjdk:8-jre-alpine
COPY --from=BUILD /src/build/libs/*.jar /bin/app.jar


CMD ["java", "-jar", "/bin/app.jar"]

