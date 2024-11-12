package org.romanzhula.rabbitmqsecondconsumer.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.romanzhula.rabbitmqsecondconsumer.configuration.RabbitmqSecondConsumerConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


@Slf4j
@RequiredArgsConstructor
@Service
public class RabbitmqSecondConsumer {

    private final RabbitmqSecondConsumerConfig rabbitmqSecondConsumerConfig;


    @RabbitListener(queues = "#{@rabbitmqSecondConsumerConfig.getQueueNameTwo()}")
    public void receiveQueueTwo(String text) {
        getLogQueueMessage(rabbitmqSecondConsumerConfig.getQueueNameTwo(), text);
    }

    private void getLogQueueMessage(String queueName, String text) {
        log.info("Text from queue {}: {}", queueName, text);
    }

}
