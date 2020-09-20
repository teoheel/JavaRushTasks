package com.javarush.task.task38.task3803;

/*
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object object = Integer.valueOf(42);
        String string = (String) object;
    }

    public void methodThrowsNullPointerException() {
        Object object = null;
        boolean equals = object.equals(new Object());
        System.out.println(equals);
    }

    public static void main(String[] args) {
        VeryComplexClass veryComplexClass = new VeryComplexClass();
//        veryComplexClass.methodThrowsClassCastException();
        veryComplexClass.methodThrowsNullPointerException();
    }
}
