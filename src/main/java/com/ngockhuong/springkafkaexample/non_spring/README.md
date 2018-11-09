# Send and receive data using kafka vs zookeeper
(Java vs kafka-clients lib)
###1. Start Zookeeper
```
sudo ./bin/zookeeper-server-start.sh config/zookeeper.properties
```
###2. Create kafka topic
```
sudo ./bin/kafka-server-start.sh config/server.properties
```
###3. Run kafka server
+ Check topic list:
```
./bin/kafka-topics.sh --list --zookeeper localhost:2181
```
+ Create topic:
```
./bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic demo
```
