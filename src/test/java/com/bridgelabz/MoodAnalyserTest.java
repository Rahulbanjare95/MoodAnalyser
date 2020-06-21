package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {

    @Test
    public void givenMessage_WhenSad_ShouldReturnSad(){
      MoodAnalyser moodAnalyser= new MoodAnalyser("sad message");
      String mood=moodAnalyser.analyseMood();
      Assert.assertEquals("SAD",mood);

    }

    @Test
    public void givenMessage_WhenNotSad_ShouldReturnHappy() {
        MoodAnalyser moodAnalyser=new MoodAnalyser("Happy Message");
        String mood=moodAnalyser.analyseMood();
        Assert.assertEquals("HAPPY",mood);
    }

    @Test
    public void givenInvalidMood_ShouldHandleException () {
       MoodAnalyser moodAnalyser =new MoodAnalyser("");
        String mood=null;

        try {
            mood=moodAnalyser.analyseMood();
            Assert.assertEquals("HAPPY",mood);
        }catch (MoodAnalyserException e){
            e.printStackTrace();
        }

    }
}
