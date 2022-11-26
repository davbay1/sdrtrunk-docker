FROM gradle:jdk17 as gradleimage
COPY . /src
WORKDIR /src
RUN gradlelew clean build

FROM openjdk:17-jre-slim
COPY --from=gradleimage /src/ /sdrtrunk/
WORKDIR /sdrtrunk
ENTRYPOINT ["./gradlew", "clean", "run"]
