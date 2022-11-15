This demo project has a Kafka producer and a consumer based on Spring Boot.

Follow steps below at https://kafka.apache.org/quickstart and start Kafka at your local machine.

* STEP 1: GET KAFKA
* STEP 2: START THE KAFKA ENVIRONMENT

Create a Kafka topic with 4 partitions from command line/terminal:

```
bin/kafka-topics.sh --create \
--bootstrap-server localhost:2181 \
--replication-factor 1 \
--partitions 4 \
--topic my-topic
```

Run `mvn clean install` and generate jar artifact of this project.

To demonstrate resilience of consuming Kafka messages, open terminal and start 4 app instances. Since our Kafka topic
has 4 partitions, each app instance will consume only 1 partition.

1. java -jar -Dserver.port=8080 target/kafka_demo-0.0.1-SNAPSHOT.jar
2. java -jar -Dserver.port=8081 target/kafka_demo-0.0.1-SNAPSHOT.jar
3. java -jar -Dserver.port=8082 target/kafka_demo-0.0.1-SNAPSHOT.jar
4. java -jar -Dserver.port=8083 target/kafka_demo-0.0.1-SNAPSHOT.jar

Browse http://localhost:8080/ to send 1000 messages to Kafka topic. Check the logs that each app instance handles one of
the 4 Kafka partitions. Kill one of the app instances then verify that one of the running 3 app instances handles 2
Kafka partitions.

* Issues
1. [AdminClient clientId=adminclient-1] Connection to node -1 (localhost/127.0.0.1:2181) could not be established. Broker may not be available. (org.apache.kafka.clients.NetworkClient)
    Go to kafka_2.13-3.3.1/config/server.properties and uncomment and change listeners like this 'listeners=PLAINTEXT://localhost:9092'. 
