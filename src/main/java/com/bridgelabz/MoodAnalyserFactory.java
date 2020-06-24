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
                    Constructor<?> DefaultConstructor = moodAnalyserClass.getDeclaredConstructor();
                    moodobj= DefaultConstructor.newInstance();
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
}
