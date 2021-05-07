package com.javarush.task.task27.task2709;

public class TransferObject {
    protected volatile boolean isValuePresent = false; //use this variable
    private int value;

    public synchronized int get() {
        while (!isValuePresent) {
            try {
                wait();
            } catch (InterruptedException ignored) {

            }
        }
        System.out.println("Got: " + value);
        isValuePresent = false;
        notifyAll();
        return value;
    }

    public synchronized void put(int value) {
        while (isValuePresent) {
            try {
                wait();
            } catch (InterruptedException ignored) {

            }
        }
        isValuePresent = true;
        this.value = value;
        System.out.println("Put: " + value);
        notifyAll();
    }
}
