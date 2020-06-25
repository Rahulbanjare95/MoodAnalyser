package com.bridgelabz;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserReflector {
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
    public static MoodAnalyser invokeMethod(MoodAnalyser moodobject,String methodName) throws MoodAnalyserException {
        try {
            return (MoodAnalyser) moodobject.getClass().getMethod(methodName).invoke(moodobject);
        }catch (NoSuchMethodException e){
            throw new MoodAnalyserException("No such Method",MoodAnalyserException.ExceptionType.NO_SUCH_METHOD);
        }
        catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static MoodAnalyser setField(MoodAnalyser moodobject, String fieldName, String fieldValue)throws MoodAnalyserException{
            try {
                Field field=moodobject.getClass().getField(fieldName);
                field.setAccessible(true);
                field.set(moodobject,fieldValue);
            } catch (NoSuchFieldException e) {
                throw new MoodAnalyserException("No such field", MoodAnalyserException.ExceptionType.NO_SUCH_FIELD);
            }
            catch (IllegalAccessException e){
                throw new MoodAnalyserException("Not Accesible",MoodAnalyserException.ExceptionType.NO_ACCESS_GIVEN);
            }
        return moodobject;
    }
}

