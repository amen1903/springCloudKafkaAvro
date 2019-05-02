package com.springcloudkafka;


import com.springkafka.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Random;

@EnableBinding(OutputSource.class)
public class KafkaProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    private final OutputSource outputSource;

    @Autowired
    public KafkaProducer(OutputSource outputSource) {
        this.outputSource = outputSource;
    }

    public boolean send() {
        Person person = Person.newBuilder()
                .setFirstName("John")
                .setLastName("Doe")
                .build();

        LOGGER.info("Producing Kafka person event: " + person.toString());

        try {
            String key = String.valueOf(new Random().nextLong());

            outputSource.outputMessageChannel()
                    .send(
                       MessageBuilder.withPayload(person)
                                .setHeader(KafkaHeaders.MESSAGE_KEY, key)
                    .build());
        } catch (Exception e) {
            LOGGER.error("Failed to produce Kafka produceProgramEvent event: " + e );
            return false;
        }
        return true;
    }

}
