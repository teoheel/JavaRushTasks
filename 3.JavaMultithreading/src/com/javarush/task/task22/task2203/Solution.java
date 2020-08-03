package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        try {
            if (string.contains("\t") && string.indexOf("\t") != string.lastIndexOf("\t")) {
                String[] strings = string.split("\\t");
                return strings[1];
            } else {
                throw new TooShortStringException();
            }
        } catch (Exception e) {
            throw new TooShortStringException();
        }
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }

    public static class TooShortStringException extends Exception {
    }
}
