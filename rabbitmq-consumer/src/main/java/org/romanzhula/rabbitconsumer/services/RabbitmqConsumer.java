package org.romanzhula.rabbitconsumer.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.romanzhula.rabbitconsumer.configurations.RabbitmqConsumerConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


@Slf4j
@RequiredArgsConstructor
@Service
public class RabbitmqConsumer {

    private final RabbitmqConsumerConfig rabbitmqConsumerConfig;


    @RabbitListener(queues = "#{@rabbitmqConsumerConfig.getQueueNameOne()}")
    public void receiveQueueOne(String text) {
        getLogQueueMessage(rabbitmqConsumerConfig.getQueueNameOne(), text);
    }

    @RabbitListener(queues = "#{@rabbitmqConsumerConfig.getQueueNameTwo()}")
    public void receiveQueueTwo(String text) {
        getLogQueueMessage(rabbitmqConsumerConfig.getQueueNameTwo(), text);
    }

    private void getLogQueueMessage(String queueName, String text) {
        log.info("Text from queue {}: {}", queueName, text);
    }

}
