package org.romanzhula.rabbitmqproducer.controllers;

import lombok.RequiredArgsConstructor;
import org.romanzhula.rabbitmqproducer.services.MessageSenderService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class MessageController {

    private final MessageSenderService messageSenderService;

    @PostMapping("/send")
    public ResponseEntity<?> sendMessage(
            @RequestBody String text
    ) {
        messageSenderService.sendMessage(text);

        return new ResponseEntity<>("Text sent successfully.", HttpStatusCode.valueOf(200));
    }

}
