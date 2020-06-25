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
        MoodAnalyser moodAnalyser=MoodAnalyserReflector.createMoodAnalyser();
        try {
            String mood=moodAnalyser.analyseMood();
            Assert.assertEquals("Happy",mood);
            //Assert.assertSame(new MoodAnalyser(),MoodAnalyserReflector.createMoodAnalyser());
            //Assert.assertEquals(new MoodAnalyser(),MoodAnalyserReflector.createMoodAnalyser());
        }catch (MoodAnalyserException e){
            e.printStackTrace();
        }
    }
    @Test
    public void givenClassName_WhenImproper_ShoulThrowMoodAnalysisException(){
        try {
            MoodAnalyser moodAnalyser=MoodAnalyserReflector.createMoodAnalyser();
        }catch (MoodAnalyserException e){
            Assert.assertEquals(MoodAnalyserException.ExceptionType.NO_SUCH_CLASS,e.exceptionType);
        }
    }
    @Test
    public void givenClass_WhenNoProperConstructor_ShouldThrowMoodAnalysisException() {
        try {
            MoodAnalyser moodAnalyser=MoodAnalyserReflector.createMoodAnalyser();
            moodAnalyser.analyseMood(" ");
        }catch (MoodAnalyserException e){
            Assert.assertEquals(MoodAnalyserException.ExceptionType.NO_SUCH_METHOD,e.exceptionType);
        }

    }

    @Test
    public void givenMoodAnalyser_whenProper_returnMoodAnalyserObject() {
        MoodAnalyser moodAnalyser=MoodAnalyserReflector.createMoodAnalyser("I am Happy");
        try {
            String mood = moodAnalyser.analyseMood();
            Assert.assertEquals("HAPPY",mood);
        }catch (MoodAnalyserException e){
            e.printStackTrace();
        }

    }

    @Test
    public void givenClassName_WhenImproper_shouldThrowMoodAnalysisException() {
        try{
            MoodAnalyser moodAnalyser=MoodAnalyserReflector.createMoodAnalyser("I am Happy");
        } catch (MoodAnalyserException e){
            Assert.assertEquals(MoodAnalyserException.ExceptionType.NO_SUCH_CLASS,e.exceptionType);
        }

    }
    @Test
    public void givenClassConstructor_WhenImproper_shouldThrowMoodAnalysisException() {
        try{
            MoodAnalyser moodAnalyser=MoodAnalyserReflector.createMoodAnalyser("I am Happy");
            String mood=moodAnalyser.analyseMood();
        }
        catch (MoodAnalyserException e){
            Assert.assertEquals(MoodAnalyserException.ExceptionType.NO_SUCH_CLASS,e.exceptionType);
        }
    }

    @Test
    public void givenHappyMessage_WhenProper_ShouldReturnHappyMessage() {
        try {
            MoodAnalyser moodAnalyser = MoodAnalyserReflector.invokeMethod(MoodAnalyserReflector.createMoodAnalyser("I am Happy"),"mood");
            Assert.assertEquals("HAPPY",moodAnalyser);
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void givenHappyMessage_WhenImproper_ShouldReturn_MoodAnalysisException() {
        try {
        MoodAnalyser moodAnalyser = MoodAnalyserReflector.invokeMethod(MoodAnalyserReflector.createMoodAnalyser("I"),"mood");
        } catch (MoodAnalyserException e) {
            Assert.assertEquals(MoodAnalyserException.ExceptionType.NO_SUCH_METHOD,e.exceptionType);
        }
    }
    @Test
    public void givenHappyMessage_WithReflector_ShouldReturnHappy(){
        try {
            MoodAnalyser moodAnalyser = MoodAnalyserReflector.setField(MoodAnalyserReflector.createMoodAnalyser("I am Happy"), "message", "I am Happy");
            MoodAnalyser analyseMood = MoodAnalyserReflector.invokeMethod(MoodAnalyserReflector.createMoodAnalyser("I am Happy"), "analyseMood");
            Assert.assertEquals("HAPPY",analyseMood);
        }
        catch (MoodAnalyserException e){
            Assert.assertEquals(MoodAnalyserException.ExceptionType.NO_SUCH_FIELD,e.exceptionType);
        }
    }
    @Test
    public void givenImproper_setField_ShouldThrowException() {
        try{
            MoodAnalyser moodAnalyser = MoodAnalyserReflector.setField(MoodAnalyserReflector.createMoodAnalyser("I am Happy"), "wrong", "I am Happy");
            MoodAnalyser analyseMood = MoodAnalyserReflector.invokeMethod(MoodAnalyserReflector.createMoodAnalyser("I am Happy"), "analyseMood");
            Assert.assertEquals("HAPPY",analyseMood);
        }catch (MoodAnalyserException e){
            Assert.assertEquals(MoodAnalyserException.ExceptionType.NO_SUCH_FIELD,e.exceptionType);
        }
    }

    @Test
    public void givenNullMessage_toSetField_shouldThrowException() {
        try{
            MoodAnalyser moodAnalyser=MoodAnalyserReflector.setField(MoodAnalyserReflector.createMoodAnalyser("I am Happy"),null,null);
            MoodAnalyser analyseMood=MoodAnalyserReflector.invokeMethod(MoodAnalyserReflector.createMoodAnalyser("I am happy"),"analyseMood");
            Assert.assertEquals("HAPPY",analyseMood);
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }
}
