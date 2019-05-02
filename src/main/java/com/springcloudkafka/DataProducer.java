package com.springcloudkafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataProducer implements ApplicationRunner {

    @Autowired
    KafkaProducer kafkaProducer;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        kafkaProducer.send();
    }
}
