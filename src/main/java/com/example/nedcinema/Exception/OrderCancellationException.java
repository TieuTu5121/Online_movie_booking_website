package com.example.nedcinema.Exception;

public class OrderCancellationException extends RuntimeException {
    public OrderCancellationException(String massage) {
       super(massage);
    }
}
