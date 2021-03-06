package com.springcloudkafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.schema.client.ConfluentSchemaRegistryClient;
import org.springframework.cloud.stream.schema.client.SchemaRegistryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by HurleyD on 03/08/2018.
 */
@Configuration
public class KafkaConfig {

    @Value("${spring.cloud.stream.schemaRegistryClient.endpoint}")
    private String endpoint;

    @Bean
    public SchemaRegistryClient confluentSchemaRegistryClient() {
        ConfluentSchemaRegistryClient client = new ConfluentSchemaRegistryClient();
        client.setEndpoint(endpoint);
        return client;
    }

}
