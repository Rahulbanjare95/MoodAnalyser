package com.bridgelabz;

public class MoodAnalyserException extends RuntimeException {
    enum ExceptionType {
        ENTERED_NULL,
        NO_SUCH_METHOD,
        NO_SUCH_CLASS,
        NO_ACCESS_GIVEN,
        NO_SUCH_FIELD,
        ENTERED_EMPTY;

     }
    public  ExceptionType exceptionType;
    public MoodAnalyserException(String message,ExceptionType exceptionType) {
        super(message);
        this.exceptionType=exceptionType;
    }
}
