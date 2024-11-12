package org.romanzhula.rabbitconsumer.configurations;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class RabbitmqConsumerConfig {

    @Value("${rabbitmq.queue.name.one}")
    private String queueNameOne;

    @Value("${rabbitmq.queue.name.two}")
    private String queueNameTwo;

}
