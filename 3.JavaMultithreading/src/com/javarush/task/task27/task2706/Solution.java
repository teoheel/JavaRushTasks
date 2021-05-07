package com.javarush.task.task27.task2706;

/* 
Убираем deadlock
*/
public class Solution {
    public static void main(String[] args) {
        final Object o1 = new Object();
        final Object o2 = new Object();
        final Solution solution = new Solution();

        new Thread(() -> solution.safeMethod(o1, o2)).start();

        new Thread(() -> solution.safeMethod(o2, o1)).start();
    }

    public void safeMethod(Object obj1, Object obj2) {
        int compareTo = obj1.toString().compareTo(obj2.toString());
        Object objectMax = compareTo > 0 ? obj1 : obj2;
        Object objectMin = compareTo <= 0 ? obj1 : obj2;
        synchronized (objectMax) {
            longTimeMethod();
            synchronized (objectMin) {
                unsafeMethod(obj1, obj2);
            }
        }
    }

    public void longTimeMethod() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {
        }
    }

    protected void unsafeMethod(Object obj1, Object obj2) {
        System.out.println(obj1 + " " + obj2);
    }
}
