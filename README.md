# Vintage Store

## Overview

Vintage Store App is a microservices-based application designed for managing books in a vintage store. The system consists of two independent microservices:

- **rest-book**: Handles book registration, including title, author, publication year, genre, and ISBN-13.

- **rest-number**: Responsible for generating ISBN-10 and ISBN-13 numbers.

## Key Features

- REST endpoints exposed using JAX-RS and CDI.
- JSON output customization with JSON-B.
- Inter-service communication via MicroProfile REST Client.
- Fault tolerance implemented with MicroProfile Fault Tolerance.
- API documentation using MicroProfile OpenAPI.
- Test the two microservices in isolation with JUnit and REST Assured.
- Native executable generation with GraalVM.
- Microservices containerized with Docker.
- Both microservices run with a single Docker Compose command.

## Technologies Used

- Java with MicroProfile
- JAX-RS, CDI, JSON-B
- JUnit, REST Assured
- MicroProfile REST Client, Fault Tolerance, OpenAPI
- GraalVM
- Docker & Docker Compose

## Project Structure

The project is composed of two main microservices:

- **rest-book**: Manages book registration. Stores data such as title, author, publication year, genre, and ISBN-13.
- **rest-number**: Generates ISBN-10 and ISBN-13 numbers. Exposes REST endpoints for generation and validation.

Each microservice includes its own configuration, unit tests, OpenAPI documentation, and Docker container.

## Installation

1. Clone the repository:
```bash
   git clone https://github.com/rachelyperezdev/vintage-store-app.git
   cd vintage-store-app
```

2. Make sure you have installed:

- Java 11+
- Maven
- Docker
- GraalVM (optional for native compilation)

## Running with Docker Compose

To run both microservices simultaneously, Docker Compose is used. Make sure Docker and Docker Compose are installed on your system.

1. Build the Docker images:

  ```bash
   docker build -t rest-book ./rest-book
   docker build -t rest-number ./rest-number
   ```
2. Start the services:
  ```bash
   docker-compose -f vintagestore-docker-compose.yaml up
   ```
3. Access the endpoints:
- **rest-book**: http://localhost:8702/api/books
- **rest-number**: http://localhost:8701/api/numbers

## Native compilation with GraalVM

Each microservice can be compiled into a native executable using GraalVM, improving performance and reducing startup time.

### Steps to compile with GraalVM:

1. Install GraalVM and configure environment variables (`JAVA_HOME`, `PATH`).
2. Ensure Native Image is available. Some GraalVM distributions include it by default. To verify, run:
```bash
   native-image --version
   ```
If it's not installed, add it with:
```bash
    gu install native-image
```
3. Compile each microservice from inside each directory (rest-book and rest-number):

- For your OS:
```bash
    mvn package -Pnative -Dmaven.test.skip=true 
```
- For native Linux executable (cross-compilation). Ensure Docker is running:
```bash
    mvn package -Pnative -Dquarkus.native.container-build=true -Dquarkus.container-image.build=true -Dmaven.test.skip=true
```

4. Run the generated binaries:

- For your OS:
```bash
    ./target/rest-number-1.0.0-SNAPSHOT-runner
    ./target/rest-book-1.0.0-SNAPSHOT-runner
```

- For native Linux executable (inside Docker):
```bash
    docker run -i --rm -p 8701:8701 rest-number:1.0.0-SNAPSHOT
    docker run -i --rm -p 8702:8702 rest-book:1.0.0-SNAPSHOT
```

## Testing with cURL

Once the services are up, you can test the endpoints using `cURL`:

### rest-number (ISBN Generation)
- Generate a new ISBN:
```bash
    curl http://localhost:8701/api/numbers
```

### rest-book (Book Management)
```bash
    curl -X POST http://localhost:8702/api/books -d "title=Harry Potter and the Philosopher's Stone&author=J.K. Rowling&year=1997&genre=Fantasy"
```