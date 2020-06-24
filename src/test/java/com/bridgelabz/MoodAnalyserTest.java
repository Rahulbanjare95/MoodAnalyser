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
        MoodAnalyser moodAnalyser=MoodAnalyserFactory.createMoodAnalyser();
        try {
            String mood=moodAnalyser.analyseMood();
            Assert.assertEquals("Happy",mood);
            //Assert.assertSame(new MoodAnalyser(),MoodAnalyserFactory.createMoodAnalyser());
            //Assert.assertEquals(new MoodAnalyser(),MoodAnalyserFactory.createMoodAnalyser());
        }catch (MoodAnalyserException e){
            e.printStackTrace();
        }
    }
    @Test
    public void givenClassName_WhenImproper_ShoulThrowMoodAnalysisException(){
        try {
            MoodAnalyser moodAnalyser=MoodAnalyserFactory.createMoodAnalyser();
        }catch (MoodAnalyserException e){
            Assert.assertEquals(MoodAnalyserException.ExceptionType.NO_SUCH_CLASS,e.exceptionType);
        }
    }
    @Test
    public void givenClass_WhenNoProperConstructor_ShouldThrowMoodAnalysisException() {
        try {
            MoodAnalyser moodAnalyser=MoodAnalyserFactory.createMoodAnalyser();
            moodAnalyser.analyseMood();
        }catch (MoodAnalyserException e){
            Assert.assertEquals(MoodAnalyserException.ExceptionType.NO_SUCH_METHOD,e.exceptionType);
        }
    }



}
