package com.pismo.challenge.microservices.exception;

public class NegativeTransactionValueException extends RuntimeException {

    public NegativeTransactionValueException(String message) {
        super(message);
    }
}
