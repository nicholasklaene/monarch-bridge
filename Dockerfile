# syntax=docker/dockerfile:1.7
#
# Multi-stage image for monarch-proxy — Monarch pass-through wrapper.
#
# Stage 1 (builder): JDK + Gradle produces the bootJar.
# Stage 2 (runtime): minimal JRE image. ~170MB final size.
#
# Session file lives OUTSIDE the container — mount a host dir to /var/monarch-proxy/session
# and set MONARCH_SESSION_PATH to point at the JSON file inside that volume.
#
# Example bind-mount (local dev, mirrors docker-compose.yml):
#   -v ${HOME}/.config/monarch-proxy:/var/monarch-proxy/session
#   -e MONARCH_SESSION_PATH=/var/monarch-proxy/session/.mm-session.json
#
# kre-stack wires this under the `monarch` Compose profile (see ~/Desktop/kre-stack/docker-compose.yml).

FROM eclipse-temurin:21-jdk-alpine AS builder
WORKDIR /app

# Layer: gradle wrapper + build config (cached across source edits).
COPY gradlew settings.gradle.kts build.gradle.kts ./
COPY gradle ./gradle
RUN chmod +x gradlew && ./gradlew --version --no-daemon

# Layer: source.
COPY api ./api

# Build the bootJar. Skip tests — CI ran them. --no-daemon for CI hygiene (no daemon
# process left behind in the build container).
RUN --mount=type=cache,target=/root/.gradle \
    ./gradlew :api:bootJar -x test --no-daemon


FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Non-root runtime user.
RUN addgroup -S app && adduser -S -G app -u 10001 app

# Copy the bootJar artifact produced in the builder stage.
COPY --from=builder --chown=app:app /app/api/build/libs/api-0.1.0-SNAPSHOT.jar api.jar

USER app

# Volume for the Monarch session JSON. Bind-mount from the host at runtime:
#   -v ${HOME}/.config/monarch-proxy:/var/monarch-proxy/session
# Then set env:
#   MONARCH_SESSION_PATH=/var/monarch-proxy/session/.mm-session.json
# The service tolerates an absent file — endpoints return 503 until bootstrapped.
VOLUME /var/monarch-proxy/session

EXPOSE 9084

# JVM_OPTS accepted at runtime for heap tuning, GC flags, etc.
ENTRYPOINT ["sh", "-c", "exec java ${JVM_OPTS:-} -jar /app/api.jar"]
