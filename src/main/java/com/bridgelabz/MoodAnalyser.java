package com.bridgelabz;

public class MoodAnalyser {
    String message;
    public MoodAnalyser() {
        message="";
    }

    public MoodAnalyser(String message) {
        this.message=message;
    }


    public String analyseMood(String message) {
        if(message.contains("sad"))
            return "SAD";
        else
            return "HAPPY";


    }
}
