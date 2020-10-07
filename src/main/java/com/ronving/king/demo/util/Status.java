package com.ronving.king.demo.util;

public enum Status {

    SUCCESS(200),
    CREATED(201),
    FAIL(400),
    BAD_REQUEST(400),
    NOT_FOUND(404),
    VALIDATION_MISTAKE(400);

    private final int statusCode;

    Status(int statusCode) {
        this.statusCode = statusCode;
    }

    public int value() {
        return statusCode;
    }

}
