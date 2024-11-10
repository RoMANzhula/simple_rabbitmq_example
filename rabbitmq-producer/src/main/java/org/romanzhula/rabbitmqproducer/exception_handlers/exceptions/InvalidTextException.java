package org.romanzhula.rabbitmqproducer.exception_handlers.exceptions;

public class InvalidTextException extends RuntimeException {

    public InvalidTextException(String message) {
        super(message);
    }

}
