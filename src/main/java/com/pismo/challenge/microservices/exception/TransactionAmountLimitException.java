package com.pismo.challenge.microservices.exception;

public class TransactionAmountLimitException extends RuntimeException {

    public TransactionAmountLimitException(String message) {
        super(message);
    }
}
