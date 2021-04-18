This demo project has a Kafka producer and a consumer based on Spring Boot.

Follow steps below at https://kafka.apache.org/quickstart and start Kafka at your local machine.

* STEP 1: GET KAFKA
* STEP 2: START THE KAFKA ENVIRONMENT

Create a Kafka topic with 4 partitions from command line/terminal:

```
bin/kafka-topics.sh --create \
--zookeeper localhost:2181 \
--replication-factor 1 \
--partitions 4 \
--topic my-topic
```

Run `maven clean install` and generate jar artifact of this project.

Open terminal and start 4 app instances.

1. java -jar -Dserver.port=8080 target/kafka_demo-0.0.1-SNAPSHOT.jar
2. java -jar -Dserver.port=8081 target/kafka_demo-0.0.1-SNAPSHOT.jar
3. java -jar -Dserver.port=8082 target/kafka_demo-0.0.1-SNAPSHOT.jar
4. java -jar -Dserver.port=8083 target/kafka_demo-0.0.1-SNAPSHOT.jar

Browse http://localhost:8080/ to send 1000 messages to Kafka topic. Each app instance will handle one of the 4 Kafka
partitions. Kill one of the app instances then verify that one of the running 3 app instances will handle 2 Kafka
partitions.
