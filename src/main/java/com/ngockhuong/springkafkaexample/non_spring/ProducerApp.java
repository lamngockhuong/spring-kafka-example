package com.ngockhuong.springkafkaexample.non_spring;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.concurrent.ExecutionException;

public class ProducerApp {
    public static void main(String[] args) {
//        runProducer();
        runCustomObjectProducer();
    }

    static void runProducer() {
        Producer<Long, String> producer = ProducerCreator.createProducer();

        for (int index = 0; index < IKafkaConstants.MESSAGE_COUNT; index ++) {
            ProducerRecord<Long, String> record = new ProducerRecord<>(IKafkaConstants.TOPIC_NAME, "This is record " + index);

            try {
                RecordMetadata metadata = producer.send(record).get();
                System.out.println("Record send with key " + index + " to partition " + metadata.partition() + " with offset " + metadata.offset());
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("Error in sending record");
                e.printStackTrace();
            }
        }
    }

    static void runCustomObjectProducer() {
        Producer<Long, CustomObject> producer = ProducerCreator.createCustomObjectProducer();

        for (int index = 0; index < IKafkaConstants.MESSAGE_COUNT; index ++) {
            ProducerRecord<Long, CustomObject> record = new ProducerRecord<>(IKafkaConstants.TOPIC_NAME, (long) index, new CustomObject(String.valueOf(index), "This is record " + index));

            try {
                RecordMetadata metadata = producer.send(record).get();
                System.out.println("Record send with key " + index + " to partition " + metadata.partition() + " with offset " + metadata.offset());
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("Error in sending record");
                e.printStackTrace();
            }
        }
    }
}
