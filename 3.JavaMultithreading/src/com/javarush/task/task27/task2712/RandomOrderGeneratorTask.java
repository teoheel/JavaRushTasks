package com.javarush.task.task27.task2712;

import java.util.List;

public class RandomOrderGeneratorTask implements Runnable {
    private final int interval;
    private final List<Tablet> tablets;

    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval) {
        this.tablets = tablets;
        this.interval = interval;
    }

    @Override
    public void run() {
        int numberOfTablet = (int) (Math.random() * tablets.size());
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(interval);
            } catch (InterruptedException ignored) {

            } finally {
                tablets.get(numberOfTablet).createTestOrder();
            }
        }
    }
}
