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

    @Value("${rabbitmq.queue.name.two}")
    private String queueNameTwo;

    private final AmqpTemplate amqpTemplate;

    public void sendMessageFirstQueue(String message) {
        if (message.isBlank()) {
            log.error("First queue - text cannot be empty!");
            throw new InvalidTextException("First queue - text cannot be empty!");
        }

        log.info("First queue - text ({}) sent successfully.", message);
        amqpTemplate.convertAndSend(queueNameOne, message);
    }

    public void sendMessageSecondQueue(String message) {
        if (message.isBlank()) {
            log.error("Second queue - text cannot be empty!");
            throw new InvalidTextException("Second queue - text cannot be empty!");
        }

        log.info("Second queue - text ({}) sent successfully.", message);
        amqpTemplate.convertAndSend(queueNameTwo, message);
    }

    public void sendMessageManuallyInputQueue(
            String message,
            String queueNameManually
    ) {
        if (message.isBlank()) {
            log.error("Manually queue - text cannot be empty!");
            throw new InvalidTextException("Manually queue - text cannot be empty!");
        }

        if (queueNameManually.isBlank()) {
            log.error("Manually queue - queue name cannot be empty!");
            throw new InvalidTextException("Manually queue - queue name cannot be empty!");
        }

        log.info("Manually queue - text ({}) sent successfully.", message);
        amqpTemplate.convertAndSend(queueNameManually, message);
    }

}
