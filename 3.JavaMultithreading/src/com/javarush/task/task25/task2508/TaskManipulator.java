package com.javarush.task.task25.task2508;

public class TaskManipulator implements CustomThreadManipulator, Runnable {
    Thread thread;

    @Override
    public void run() {
        System.out.println(thread.getName());
        try {
            while (!thread.isInterrupted()) {
                Thread.sleep(100);
                System.out.println(thread.getName());
            }
        } catch (InterruptedException e) {
        }
    }

    @Override
    public void start(String threadName) {
        thread = new Thread(this, threadName);
        thread.start();
    }

    @Override
    public void stop() {
        thread.interrupt();
    }
}
