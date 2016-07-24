package com.place.interest.exceptions;

public class ErrorInfo {

    private final int responseCode;
    private final String errorMessage;

    public ErrorInfo(int responseCode, String errorMessage) {
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
