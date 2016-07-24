package com.place.interest.exceptions;

public class GenericException extends RuntimeException {

    private final int responseCode;
    private final String errorMessage;

    public GenericException(int responseCode, String errorMessage) {
        this.responseCode = responseCode;
        this.errorMessage = errorMessage;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
