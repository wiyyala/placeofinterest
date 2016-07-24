package com.place.interest.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionProcessor {

    @ExceptionHandler(GenericException.class)
    @ResponseBody
    public ErrorInfo handleBadRequests(GenericException e) {
        return new ErrorInfo(e.getResponseCode(),e.getErrorMessage());
    }
}
