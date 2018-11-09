# spring-kafka-example
Using kafka and zookeeper (using kafka-clients, kafka-streams vs spring-kafka)

## Kafka
* Run kafka:
```
sudo ./bin/kafka-server-start.sh config/server.properties
```
* Stop kafka:
```
sudo ./bin/kafka-server-stop.sh
```
* List topics:
```
./bin/kafka-topics.sh --list --zookeeper localhost:2181
```
* Delete a topic (demo):
```
./bin/kafka-topics.sh --zookeeper localhost:2181 --delete --topic demo
```

## Zookeeper
* Run zookeeper:
```
sudo ./bin/zookeeper-server-start.sh config/zookeeper.properties
```
* Stop zookeeper:
```
sudo ./bin/zookeeper-server-stop.sh
```

## 1. Non Spring - Producer + Consumer
* Create a topic (demo):
```
./bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic demo
```

## 2. Spring - Producer + Consumer
* Create a topic (demo):
```
./bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic foo.t
```

## 3. Non Spring - Producer + Stream
* Create a topic (streams-plaintext-input):
```
./bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic streams-plaintext-input
```
* Create a topic (streams-wordcount-output):

_Note: We create the output topic with compaction enabled because the output stream is a changelog stream_
```
./bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic streams-wordcount-output --config cleanup.policy=compact
```
* Start WordCountApp
* Send message to topic "streams-plaintext-input"
```
./bin/kafka-console-producer.sh --broker-list localhost:9092 --topic streams-plaintext-input
```
* Check output at topic "streams-wordcount-output"
```
./bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 \
      --topic streams-wordcount-output \
      --from-beginning \
      --formatter kafka.tools.DefaultMessageFormatter \
      --property print.key=true \
      --property print.value=true \
      --property key.deserializer=org.apache.kafka.common.serialization.StringDeserializer \
      --property value.deserializer=org.apache.kafka.common.serialization.LongDeserializer
```
## 4. Spring - Producer + Stream
