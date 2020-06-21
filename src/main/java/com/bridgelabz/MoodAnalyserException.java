package com.bridgelabz;

public class MoodAnalyserException extends RuntimeException {
    enum ExceptionType {
        ENTERED_NULL,
        ENTERED_EMPTY;
    }
    public  ExceptionType exceptionType;
    public MoodAnalyserException(String message,ExceptionType exceptionType) {
        super(message);
        this.exceptionType=exceptionType;
    }
}
