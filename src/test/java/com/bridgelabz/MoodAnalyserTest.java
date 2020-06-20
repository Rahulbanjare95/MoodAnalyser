package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {
    @Test
    public void givenMessage_WhenSad_ShouldReturnSad(){
      MoodAnalyser moodAnalyser= new MoodAnalyser();
      String mood=moodAnalyser.analyseMood("Passing sad message");
      Assert.assertEquals("SAD",mood);

    }
}
