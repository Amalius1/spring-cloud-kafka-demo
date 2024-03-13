# Kafka Demo App

App to show the usage of Kafka and Cloud Bus to trigger events between multiple services.

## Pre-requisites

* Java 17
* Docker

## How to run the code

1. Clone the repository
2. Open the terminal and navigate to the project folder
3. Run the following command to install the required packages

```
./gradlew clean build
```

4. Run the following command to build docker image

```
 docker build -t kafka-demo-app:0.0.1 .
```

5. Run the following command to start the docker compose

```
cd kafka-broker
docker-compose up
```

6. Query the endpoint to trigger the cloud bus event

```
curl -X POST http://localhost:8080/manager/upload -v
```
