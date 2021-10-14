package io.xventure.testing.xventurehibernatepractice.Error;

import org.springframework.http.HttpStatus;

public enum ErrorSelector {
    DOCTOR_NOT_FOUND("Doctor is not available",HttpStatus.BAD_REQUEST),
    DOCTOR_LIST_IS_EMPTY("Doctor list is empty",HttpStatus.BAD_REQUEST),
    CHANNEL_NOT_FOUND("Channel is not available",HttpStatus.BAD_REQUEST),
    CHANNEL_LIST_IS_EMPTY("Channel list is not available",HttpStatus.BAD_REQUEST);

    private final String message;
    private final HttpStatus httpStatus;

    ErrorSelector(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
