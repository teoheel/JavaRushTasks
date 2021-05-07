package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    Thread target;

    public LoggingStateThread(Thread target) {
        this.target = target;
    }

    @Override
    public void run() {
        State currentState, newState = null;
        do {
            currentState = target.getState();
            if (currentState != newState) {
                System.out.println(currentState);
                newState = currentState;
            }
        } while (currentState != State.TERMINATED);
    }
}
