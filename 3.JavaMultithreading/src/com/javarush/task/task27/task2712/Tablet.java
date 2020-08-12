package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.TestOrder;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.NoAvailableVideoEventDataRow;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.javarush.task.task27.task2712.ConsoleHelper.writeMessage;

public class Tablet {
    private static final Logger logger = Logger.getLogger(Tablet.class.getName());
    private final int number;
    private LinkedBlockingQueue<Order> queue;
    private StatisticManager statisticManager = StatisticManager.getInstance();
    private int timeSeconds;

    public Tablet(int number) {
        this.number = number;
    }

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    public void createTestOrder() {
        TestOrder order = null;
        try {
            order = new TestOrder(this);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
        processOrder(Objects.requireNonNull(order));
    }

    private void processOrder(Order order) {
        timeSeconds = order.getTotalCookingTime() * 60;
        if (!order.isEmpty()) {
            try {
                try {
                    queue.put(order);
                } catch (InterruptedException ignored) {
                }
                AdvertisementManager advertisementManager = new AdvertisementManager(timeSeconds);
                advertisementManager.processVideos();
                writeMessage(order.toString());
            } catch (NoVideoAvailableException e) {
                logger.log(Level.INFO, String.format("No video is available for the order %s", order));
                statisticManager.register(new NoAvailableVideoEventDataRow(timeSeconds));
            }
        }
    }

    @Override
    public String toString() {
        return String.format("Tablet{number=%d}", number);
    }
}
