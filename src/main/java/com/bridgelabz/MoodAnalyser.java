package com.bridgelabz;

public class MoodAnalyser {
    String message;

    public MoodAnalyser(String message) {
        this.message = message;

    }


    public String analyseMood() {
        try {
            if (message.contains("sad"))
                return "SAD";
            else
                return "HAPPY";
        } catch (MoodAnalyserException ex) {
            throw new MoodAnalyserException("Please Enter valid message");
        }
    }
}



