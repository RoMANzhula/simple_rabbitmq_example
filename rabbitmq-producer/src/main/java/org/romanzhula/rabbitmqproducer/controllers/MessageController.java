package org.romanzhula.rabbitmqproducer.controllers;

import lombok.RequiredArgsConstructor;
import org.romanzhula.rabbitmqproducer.services.MessageSenderService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class MessageController {

    private final MessageSenderService messageSenderService;

    @PostMapping("/send/first-queue")
    public ResponseEntity<?> sendMessageFirstQueue(
            @RequestBody String text
    ) {
        messageSenderService.sendMessageFirstQueue(text);

        return new ResponseEntity<>("Queue first - text sent successfully.", HttpStatusCode.valueOf(200));
    }

    @PostMapping("/send/second-queue")
    public ResponseEntity<?> sendMessageSecondQueue(
            @RequestBody String text
    ) {
        messageSenderService.sendMessageSecondQueue(text);

        return new ResponseEntity<>("Queue second - text sent successfully.", HttpStatusCode.valueOf(200));
    }

    @PostMapping("/send/manually")
    public ResponseEntity<?> sendMessageManuallyInputQueue(
            @RequestBody String text,
            @RequestParam String queueName
    ) {
        messageSenderService.sendMessageManuallyInputQueue(text, queueName);

        return new ResponseEntity<>(
                "Text sent successfully to queue: " + queueName,
                HttpStatusCode.valueOf(200)
        );
    }

    @PostMapping("/send/fanout-exchange")
    public ResponseEntity<?> sendMessageFanoutExchange(
            @RequestBody String text
    ) {
        messageSenderService.sendMessageFanoutExchange(text);

        return new ResponseEntity<>(
                "Text sent successfully to all queues!",
                HttpStatusCode.valueOf(200)
        );
    }

}
