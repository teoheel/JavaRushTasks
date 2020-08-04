package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class OrderManager implements Observer {
    private final LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

    public OrderManager() {
        StatisticManager statisticManager = StatisticManager.getInstance();
        Set<Cook> cooks = statisticManager.getCooks();
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                for (Cook cook : cooks) {
                    if (!cook.isBusy()) {
                        while (orderQueue.isEmpty()) {
                            try {
                                Thread.sleep(10);
                            } catch (InterruptedException ignored) {
                            }
                        }
                        new Thread(() -> {
                            cook.startCookingOrder(orderQueue.poll());
                        }).start();
                    }
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    @Override
    public void update(Observable o, Object arg) {
        try {
            orderQueue.put((Order) arg);
        } catch (InterruptedException ignored) {

        }
    }
}
