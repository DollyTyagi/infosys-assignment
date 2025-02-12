package com.example.rewardportalproject.exceptionHandler;

public class TransactionNotFoundException extends RuntimeException {
    public TransactionNotFoundException(String message) {
        super(message);
    }

}
