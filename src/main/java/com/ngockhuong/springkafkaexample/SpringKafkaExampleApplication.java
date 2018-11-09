package com.ngockhuong.springkafkaexample;

import com.ngockhuong.springkafkaexample.spring.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringKafkaExampleApplication implements CommandLineRunner {

    @Autowired
    private Sender sender;

    public static void main(String[] args) {
        SpringApplication.run(SpringKafkaExampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        sender.send("Spring Kafka Producer and Consumer Example");
    }
}
