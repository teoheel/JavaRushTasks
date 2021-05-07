package com.javarush.task.task25.task2512;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {
    public static void main(String[] args) {
        new Solution().uncaughtException(Thread.currentThread(), new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        recursion(e);
    }

    public void recursion(Throwable e) {
        if (e.getCause() != null) recursion(e.getCause());
        System.out.println(e);
    }
}
