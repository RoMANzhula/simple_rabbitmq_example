package org.romanzhula.rabbitmqproducer.services;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.romanzhula.rabbitmqproducer.exception_handlers.exceptions.InvalidTextException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Slf4j
@Setter
@RequiredArgsConstructor
@Service
public class MessageSenderService {

    @Value("${rabbitmq.queue.name.one}")
    private String queueNameOne;

    private final AmqpTemplate amqpTemplate;

    public void sendMessage(String message) {
        if (message.isBlank()) {
            log.error("Text cannot be empty!");
            throw new InvalidTextException("Text cannot be empty!");
        }

        log.info("Text ({}) sent successfully.", message);
        amqpTemplate.convertAndSend(queueNameOne, message);
    }

}
