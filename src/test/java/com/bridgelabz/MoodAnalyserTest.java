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
    public void  givenNullMessage_shouldInformUser(){
        try {
            MoodAnalyser moodAnalyser=new MoodAnalyser(null);
        } catch (MoodAnalyserException ex){
            Assert.assertEquals(MoodAnalyserException.ExceptionType.ENTERED_NULL,ex.exceptionType);
        }


    }
    @Test
    public void  givenEmptyMessage_shouldInformUser() {
        try {
            MoodAnalyser moodAnalyser = new MoodAnalyser("");
        } catch (MoodAnalyserException ex) {
            Assert.assertEquals(MoodAnalyserException.ExceptionType.ENTERED_EMPTY, ex.exceptionType);
        }

    }

    @Test
    public void givenMoodAnalyserClassName_ShouldReturnMoodAnalyserObject() {
        Assert.assertEquals(new MoodAnalyser(),MoodAnalyserFactory.createMoodAnalyser());
    }
}
