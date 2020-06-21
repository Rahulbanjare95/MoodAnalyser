package com.bridgelabz;

public class MoodAnalyser {
    String message;

    public MoodAnalyser(String message) {
        this.message = message;
    }
    public String analyseMood() {
        try {
            if(message.length()==0)
                throw new MoodAnalyserException("Please don't enter empty string",MoodAnalyserException.ExceptionType.ENTERED_EMPTY);
            if (message.contains("sad"))
                return "SAD";
            else
                return "HAPPY";
        } catch (NullPointerException e) {
            throw new MoodAnalyserException("Please enter valid mood message",MoodAnalyserException.ExceptionType.ENTERED_NULL);
        }
    }
}



