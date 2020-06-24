package com.bridgelabz;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {

    public static MoodAnalyser  createMoodAnalyserNoParam()  {
        try {
            Class<?> moodAnalyserClass = Class.forName("com.bridgelabz.MoodAnalyser");
            Constructor<?> moodConstructor = moodAnalyserClass.getConstructor();
            Object moodObject = moodConstructor.newInstance();
            return (MoodAnalyser)moodObject;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static MoodAnalyser  createMoodAnalyser(String message)  {
        try {
            Class<?> moodAnalyserClass = Class.forName("com.bridgelabz.MoodAnalyser");
            Constructor<?> paramconstructor = moodAnalyserClass.getConstructor(String.class);
            Object moodObjectParameter=paramconstructor.newInstance(message);
            return (MoodAnalyser)moodObjectParameter;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
