package org.romanzhula.rabbitconsumer.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class RabbitmqConsumer {

    @RabbitListener(queues = {"QueueForFistConsumerTransient"})
    public void receiveQueueOne(String text) {
        log.info("Text from queue QueueForFistConsumerTransient: {}", text);
    }

    @RabbitListener(queues = {"QueueForSecondConsumerDurable"})
    public void receiveQueueTwo(String text) {
        log.info("Text from queue QueueForSecondConsumerDurable: {}", text);
    }

}
