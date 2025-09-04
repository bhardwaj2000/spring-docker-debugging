# spring-docker-debugging

A sample Spring Boot project demonstrating how to debug applications running inside Docker containers, with CI/CD support via Jenkins.

## Overview

This repository provides a template for running, developing, and debugging Spring Boot applications with Docker. It also includes Jenkins pipeline automation for building and pushing Docker images.

## Features

- **Spring Boot**: Production-ready application framework
- **Docker**: Containerizes the application for consistent environments
- **Remote Debugging**: Easily attach your IDE to the running container
- **Jenkins Pipeline**: Automates build and push of Docker images

## Getting Started

### Prerequisites

- [Java 17+](https://adoptopenjdk.net/)
- [Maven](https://maven.apache.org/)
- [Docker](https://www.docker.com/get-started)
- [Jenkins](https://www.jenkins.io/) (optional, for CI/CD)

### Build the Application

```bash
mvn clean package
```

### Build the Docker Image

```bash
docker build -t spring-docker-debugging:1.0 .
```

### Run the Application

```bash
docker run -p 8080:8080 -p 8000:8000 spring-docker-debugging:1.0
```
- The application will be available at [http://localhost:8080](http://localhost:8080).
- Debugger can be attached at port `8000` (or configure as needed).

### Run with Remote Debugging

To enable JVM remote debugging, you can pass the following environment variable:

```bash
docker run -p 8080:8080 -p 8000:8000 \
  -e JAVA_TOOL_OPTIONS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:8000" \
  spring-docker-debugging:1.0
```
- The application runs on port `8080`.  
- Attach your IDE to port `8000` for debugging.

#### Steps to Attach IntelliJ IDEA Debugger

1. **Start the Docker container with debugging enabled**  
   (use the above command with port `8000` exposed).
2. **Open your project in IntelliJ IDEA.**
3. **Go to `Run > Edit Configurations...`**
4. **Click the `+` icon and select `Remote JVM Debug` (or `Remote`).**
5. **Set the following in the configuration:**
   - **Host:** `localhost`
   - **Port:** `8000`
   - (Leave other defaults, or adjust as needed)
6. **Apply and OK to save.**
7. **Click `Debug` on this configuration.**
8. **Place breakpoints in your code (for example, inside controllers or services).**
9. **Interact with your application (visit endpoints, trigger actions).**
10. **IntelliJ will stop at your breakpoints, allowing you to inspect variables and step through code running inside the Docker container.**

## Jenkins Pipeline

A `Jenkinsfile` is included for automating the build and push process of Docker images.

Typical stages:
- Build Spring Boot JAR
- Build Docker image
- Push Docker image to a registry

You can configure Jenkins to trigger the pipeline on code changes.

## Project Structure

```
src/
 └── main/
     └── java/
         └── <your_package>/
             └── Application.java
Dockerfile
Jenkinsfile
pom.xml
```

## License

This project is licensed under the MKS License.

---

Feel free to fork, contribute, or open issues!
