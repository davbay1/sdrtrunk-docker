FROM gradle:jdk17 as gradleimage
COPY . /sdrtrunk-docker
WORKDIR /sdrtrunk-docker
RUN gradlelew clean build

FROM openjdk:17-jre-slim
COPY --from=gradleimage /sdrtrunk-docker/ /sdrtrunk/
WORKDIR /sdrtrunk
ENTRYPOINT ["./gradlew", "clean", "run"]
