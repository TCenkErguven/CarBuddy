package com.carbuddy.exception;

import lombok.Getter;

@Getter
public class CarBuddyException extends RuntimeException{
    private final ErrorType errorType;
    public CarBuddyException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }
    public CarBuddyException(ErrorType errorType, String message){
        super(message);
        this.errorType = errorType;
    }
}
