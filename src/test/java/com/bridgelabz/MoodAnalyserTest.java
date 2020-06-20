package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {
    MoodAnalyser moodAnalyser=new MoodAnalyser();
    @Test
    public void givenMessage_WhenSad_ShouldReturnSad(){
      //MoodAnalyser moodAnalyser= new MoodAnalyser();
      String mood=moodAnalyser.analyseMood("Passing sad message");
      Assert.assertEquals("SAD",mood);

    }

    @Test
    public void givenMessage_WhenNotSad_ShoulfReturnHappy() {
        //MoodAnalyser moodAnalyser=new MoodAnalyser("Angry");
       String mood=moodAnalyser.analyseMood("Angry");
        Assert.assertEquals("HAPPY",mood);
    }

}
