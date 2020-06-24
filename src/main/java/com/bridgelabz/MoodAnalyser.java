package com.bridgelabz;

public class MoodAnalyser implements MoodAnalyserInt {
   private String message;

    public MoodAnalyser(String message) {
        this.message = message;
    }
    public  MoodAnalyser(){

    }
    public String analyseMood(String message){
        this.message=message;
        return analyseMood();
    }

    public String analyseMood() throws MoodAnalyserException {
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

    public boolean equals(MoodAnalyser newobj ){
        if(this.analyseMood().equals(newobj.analyseMood()))
            return true;
        return false;
    }
}



