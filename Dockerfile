# syntax=docker/dockerfile:1.7
#
# Multi-stage image for monarch-bridge - Monarch pass-through wrapper.
#
# Stage 1 (builder): JDK + Gradle produces the bootJar.
# Stage 2 (runtime): minimal JRE image. ~170MB final size.
#
# Session file lives OUTSIDE the container - mount a host dir to /var/monarch-bridge/session
# and set MONARCH_SESSION_PATH to point at the JSON file inside that volume.
#
# Example bind-mount (local dev, mirrors docker-compose.yml):
#   -v ${HOME}/.config/monarch-bridge:/var/monarch-bridge/session
#   -e MONARCH_SESSION_PATH=/var/monarch-bridge/session/.mm-session.json
#
# kre-stack wires this under the `monarch` Compose profile (see ~/Desktop/kre-stack/docker-compose.yml).

FROM eclipse-temurin:21-jdk-alpine AS builder
WORKDIR /app

# Layer: gradle wrapper + build config (cached across source edits).
# gradle.properties is REQUIRED here: it carries `kotlin.daemon.jvmargs=-Xmx5g`,
# which sizes the Kotlin compile daemon. Without it the in-container compile runs
# at the default heap and OOMs on the large generated source tree (the failure on
# CI run 26579517004 / commit 59f85ab).
COPY gradlew settings.gradle.kts build.gradle.kts gradle.properties ./
COPY gradle ./gradle
RUN chmod +x gradlew && ./gradlew --version --no-daemon

# Give Gradle + the Kotlin compile daemon enough heap for the large generated
# tree. GRADLE_OPTS sizes the Gradle JVM; kotlin.daemon.jvmargs (in
# gradle.properties, copied above) sizes the Kotlin compiler. arm64-under-QEMU
# made the OOM worse, hence the headroom.
ENV GRADLE_OPTS="-Dorg.gradle.jvmargs=-Xmx5g -XX:MaxMetaspaceSize=512m"

# Layer: source.
COPY app ./app
# OpenAPI spec is the source of truth - codegen reads from openapi/monarch-bridge.yaml
# and the runtime serves it from /openapi (Swagger UI loads from there).
COPY openapi ./openapi

# Build the bootJar. Skip tests - CI ran them. --no-daemon for CI hygiene (no daemon
# process left behind in the build container).
RUN --mount=type=cache,target=/root/.gradle \
    ./gradlew :app:bootJar -x test --no-daemon


FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Non-root runtime user.
RUN addgroup -S app && adduser -S -G app -u 10001 app

# Copy the bootJar artifact produced in the builder stage.
# bootJar emits two artifacts: the runnable fat jar `app-<version>.jar` and a
# dependency-less `app-<version>-plain.jar`. We want ONLY the runnable one.
# A glob can't disambiguate in a single COPY (app-[0-9]*.jar matches the plain
# jar too, since `-plain` trails the version digits), so stage both then prune:
# delete the plain jar and rename whatever runnable jar remains to app.jar. This
# is robust to the version string (works for 1.0.0, 1.2.3, etc.).
COPY --from=builder --chown=app:app /app/app/build/libs/app-[0-9]*.jar ./libs/
RUN rm -f ./libs/*-plain.jar && mv ./libs/*.jar app.jar && rmdir ./libs

USER app

# Volume for the Monarch session JSON. Bind-mount from the host at runtime:
#   -v ${HOME}/.config/monarch-bridge:/var/monarch-bridge/session
# Then set env:
#   MONARCH_SESSION_PATH=/var/monarch-bridge/session/.mm-session.json
# The service tolerates an absent file - endpoints return 503 until bootstrapped.
VOLUME /var/monarch-bridge/session

EXPOSE 9084

# JVM_OPTS accepted at runtime for heap tuning, GC flags, etc.
ENTRYPOINT ["sh", "-c", "exec java ${JVM_OPTS:-} -jar /app/app.jar"]
