package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }

    public static void main(String[] args) {
        for (Thread thread : threads) {
            thread.start();
        }
    }

    public static class Thread1 extends Thread {
        @Override
        public void run() {
            while (true) {

            }
        }
    }

    public static class Thread2 extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException");
                }
            }
        }
    }

    public static class Thread3 extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Thread4 extends Thread implements Message {
        public int count = 0;

        @Override
        public void showWarning() {
            interrupt();
        }

        @Override
        public void run() {
            while (!interrupted()) {

            }
        }
    }

    public static class Thread5 extends Thread {
        public int sum = 0;
        public String number;

        @Override
        public void run() {
            try {
                while (true) {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    number = reader.readLine();
                    if (!number.equals("N")) {
                        sum += Integer.parseInt(number);
                    } else {
                        System.out.println(sum);
                        break;
                    }
                }
            } catch (IOException e) {
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }
}