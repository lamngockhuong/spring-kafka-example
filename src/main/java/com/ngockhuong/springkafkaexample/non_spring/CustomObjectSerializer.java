package com.ngockhuong.springkafkaexample.non_spring;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class CustomObjectSerializer implements Serializer<CustomObject> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String topic, CustomObject data) {
        byte[] retVal = null;
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            retVal = objectMapper.writeValueAsString(data).getBytes();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            System.out.println("Error in serializing object"+ data);
        }

        return retVal;
    }

    @Override
    public void close() {

    }
}
