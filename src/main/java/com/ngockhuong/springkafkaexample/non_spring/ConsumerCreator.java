package com.ngockhuong.springkafkaexample.non_spring;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Collections;
import java.util.Properties;

public class ConsumerCreator {
    public static Consumer<Long, String> createConsumer() {
        Properties pros = new Properties();
        pros.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, IKafkaConstants.KAFKA_BROKER);
        pros.put(ConsumerConfig.GROUP_ID_CONFIG, IKafkaConstants.GROUP_ID_CONFIG);
        pros.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, LongDeserializer.class.getName());
        pros.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        pros.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, IKafkaConstants.MAX_POLL_RECORDS);
        pros.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
        pros.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, IKafkaConstants.OFFSET_RESET_EARLIEST);

        Consumer<Long, String> consumer = new KafkaConsumer<>(pros);
        consumer.subscribe(Collections.singletonList(IKafkaConstants.TOPIC_NAME));

        return consumer;
    }

    public static Consumer<Long, CustomObject> createCustomObjectConsumer() {
        Properties pros = new Properties();
        pros.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, IKafkaConstants.KAFKA_BROKER);
        pros.put(ConsumerConfig.GROUP_ID_CONFIG, IKafkaConstants.GROUP_ID_CONFIG);
        pros.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, LongDeserializer.class.getName());
        pros.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, CustomObjectDeserializer.class.getName());
        pros.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, IKafkaConstants.MAX_POLL_RECORDS);
        pros.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
        pros.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, IKafkaConstants.OFFSET_RESET_EARLIEST);

        Consumer<Long, CustomObject> consumer = new KafkaConsumer<>(pros);
        consumer.subscribe(Collections.singletonList(IKafkaConstants.TOPIC_NAME));

        return consumer;
    }
}
