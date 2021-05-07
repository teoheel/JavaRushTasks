package com.javarush.task.task38.task3803;

/*
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object object = Integer.valueOf(42);
        String string = (String) object;
        System.out.println(string);
    }

    public void methodThrowsNullPointerException() {
        Object object = null;
        boolean equals = object.equals(new Object());
        System.out.println(equals);
    }

    public static void main(String[] args) {

    }
}
