package com.lowgistic.management.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import com.lowgistic.management.service.dto.UtilisateurDto;

public class Sender {

    private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

    @Autowired
    private KafkaTemplate<String, UtilisateurDto> simpleKafkaTemplate;

    public void send(String topic, UtilisateurDto payload) {
        LOGGER.info("sending payload='{}' to topic='{}'", payload, topic);
        simpleKafkaTemplate.send(topic, payload);
    }
}