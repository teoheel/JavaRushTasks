package com.javarush.task.task36.task3602;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collections;

/*
Найти класс по описанию Ӏ Java Collections: 6 уровень, 6 лекция
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class<?> getExpectedClass() {
        Class<?>[] classes = Collections.class.getDeclaredClasses();
        for (Class<?> c : classes) {
            if (Modifier.isPrivate(c.getModifiers()) && Modifier.isStatic(c.getModifiers())) {
                try {
                    Constructor<?> constructor = c.getDeclaredConstructor();
                    constructor.setAccessible(true);
                    Method method = c.getDeclaredMethod("get", int.class);
                    method.setAccessible(true);
                    method.invoke(constructor.newInstance(), 0);
                } catch (InvocationTargetException e) {
                    if (e.getCause().toString().contains("IndexOutOfBoundsException")) {
                        return c;
                    }
                } catch (NoSuchMethodException | IllegalAccessException | InstantiationException ignored) {
                }
            }
        }
        return null;
    }
}