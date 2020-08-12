package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.List;
import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;

import static com.javarush.task.task27.task2712.ConsoleHelper.writeMessage;

public class Cook extends Observable implements Runnable {
    private final String name;
    private LinkedBlockingQueue<Order> queue = new LinkedBlockingQueue<>();
    private boolean busy;

    public Cook(String name) {
        this.name = name;
    }

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    public boolean isBusy() {
        return busy;
    }

    @Override
    public String toString() {
        return name;
    }

    public void startCookingOrder(Order order) {
        busy = true;
        StatisticManager statisticManager = StatisticManager.getInstance();
        int totalCookingTime = order.getTotalCookingTime();
        int sleepingTime = totalCookingTime * 10;
        List<Dish> dishes = order.getDishes();
        writeMessage(String.format("Start cooking - %s, cooking time - %dmin", order, totalCookingTime));
        setChanged();
        notifyObservers(order);
        statisticManager.register(new CookedOrderEventDataRow(order.getTablet().toString(), name, totalCookingTime, dishes));
        try {
            Thread.sleep(sleepingTime);
        } catch (InterruptedException ignored) {

        }
        busy = false;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException ignored) {
            }
            if (queue.peek() != null) {
                if (!this.isBusy()) {
                    try {
                        Order order = queue.take();
                        startCookingOrder(order);
                    } catch (InterruptedException ignored) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }
}
