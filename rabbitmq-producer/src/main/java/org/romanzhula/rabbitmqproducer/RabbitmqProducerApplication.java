package org.romanzhula.rabbitmqproducer;

import jakarta.annotation.PostConstruct;
import org.springframework.amqp.core.Queue;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RequiredArgsConstructor
@SpringBootApplication
public class RabbitmqProducerApplication {

    private final RabbitAdmin rabbitAdmin;
    private final Queue queueOne;
    private final Queue queueTwo;

    @PostConstruct //run this method after finished injection dependencies, but before app will get request
    public void declareQueue() {
        rabbitAdmin.declareQueue(queueOne);
        rabbitAdmin.declareQueue(queueTwo);
    }


    public static void main(String[] args) {
        SpringApplication.run(RabbitmqProducerApplication.class, args);
    }

}
