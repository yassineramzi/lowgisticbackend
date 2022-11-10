package com.lowgistic.email.receiver;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import com.lowgistic.email.service.EmailService;
import com.lowgistic.email.service.dto.UtilisateurDto;

import freemarker.template.TemplateException;

public class Receiver {
    private static final Logger log = LoggerFactory.getLogger(Receiver.class);
    private CountDownLatch latch = new CountDownLatch(1);
    
    @Autowired
    private EmailService emailService;

    @KafkaListener(topics = "${spring.kafka.topic.userRegistered}")
    public void receive(UtilisateurDto payload) {
        log.info("receivedLoad='{}'", payload);
        try {
            emailService.sendEmail(payload);
        } catch (MessagingException | IOException | TemplateException e) {
            log.error("An error occured while sending mail : {}", e);
        }
        latch.countDown();
    }
}
