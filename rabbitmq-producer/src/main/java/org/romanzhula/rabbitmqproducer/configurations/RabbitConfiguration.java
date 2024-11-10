package org.romanzhula.rabbitmqproducer.configurations;


import lombok.Setter;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Setter
@Configuration
public class RabbitConfiguration {

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${rabbitmq.queue.name.one}")
    private String queueNameOne;

    @Value("${rabbitmq.queue.name.two}")
    private String queueNameTwo;


    @Bean
    public Queue queueOne() {
        // durable "false" - this queue will be removed after stop server
        return new Queue(queueNameOne, false);
    }

    @Bean
    public Queue queueTwo() {
        //durable "true" - this queue will be saved by rabbitmq even after restart server
        return new Queue(queueNameTwo, true);
    }

    @Bean
    public CachingConnectionFactory cachingConnectionFactory() {
        // For running rabbitmq during run our application
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(host);
        cachingConnectionFactory.setUsername(username);
        cachingConnectionFactory.setPassword(password);

        return cachingConnectionFactory;
    }

    @Bean
    public RabbitAdmin rabbitAdmin() {
        return new RabbitAdmin(cachingConnectionFactory());
    }

}
