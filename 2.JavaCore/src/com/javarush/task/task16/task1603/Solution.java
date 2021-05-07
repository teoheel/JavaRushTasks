package com.javarush.task.task16.task1603;

import java.util.ArrayList;
import java.util.List;

/* 
Список и нити
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        //Add your code here - добавьте свой код тут
        SpecialThread sThread1 = new SpecialThread();
        SpecialThread sThread2 = new SpecialThread();
        SpecialThread sThread3 = new SpecialThread();
        SpecialThread sThread4 = new SpecialThread();
        SpecialThread sThread5 = new SpecialThread();
        Thread thread1 = new Thread(sThread1);
        Thread thread2 = new Thread(sThread2);
        Thread thread3 = new Thread(sThread3);
        Thread thread4 = new Thread(sThread4);
        Thread thread5 = new Thread(sThread5);

        list.add(thread1);
        list.add(thread2);
        list.add(thread3);
        list.add(thread4);
        list.add(thread5);
    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's a run method inside SpecialThread");
        }
    }
}
