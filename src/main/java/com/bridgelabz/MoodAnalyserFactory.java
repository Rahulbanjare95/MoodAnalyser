package com.bridgelabz;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
    public static MoodAnalyser  createMoodAnalyser(String ... message) throws MoodAnalyserException  {
        try {
            Class<?> moodAnalyserClass = Class.forName("com.bridgelabz.MoodAnalyser");
            Object moodobj;
            if(message.length!=0) {
                Constructor<?> paramconstructor = moodAnalyserClass.getConstructor(String.class);
                moodobj = paramconstructor.newInstance(message);
            }
            else{
                    Constructor<?> defaultConstructor = moodAnalyserClass.getConstructor();
                    moodobj= defaultConstructor.newInstance();
                }
            return (MoodAnalyser)moodobj;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            throw new MoodAnalyserException("Class Not Found", MoodAnalyserException.ExceptionType.NO_SUCH_CLASS);
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }
    public static MoodAnalyser invokeMethod(MoodAnalyser moodobject,String methodName) throws NoSuchMethodException {
        try {
            return (MoodAnalyser) moodobject.getClass().getMethod(methodName).invoke(moodobject);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }
}
