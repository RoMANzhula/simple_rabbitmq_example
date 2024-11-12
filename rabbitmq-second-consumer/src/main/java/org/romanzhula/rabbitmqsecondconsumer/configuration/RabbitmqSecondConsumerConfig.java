package org.romanzhula.rabbitmqsecondconsumer.configuration;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Getter
@Configuration
public class RabbitmqSecondConsumerConfig {

    @Value("${rabbitmq.queue.name.two}")
    private String queueNameTwo;

}
