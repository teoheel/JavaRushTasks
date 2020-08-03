package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.List;
import java.util.Observable;

import static com.javarush.task.task27.task2712.ConsoleHelper.writeMessage;

public class Cook extends Observable {
    private final String name;
    private boolean busy;

    public Cook(String name) {
        this.name = name;
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
        try {
            Thread.sleep(sleepingTime);
            statisticManager.register(new CookedOrderEventDataRow(order.getTablet().toString(), name, totalCookingTime, dishes));
            writeMessage(String.format("Start cooking - %s, cooking time - %dmin", order, totalCookingTime));
            setChanged();
            notifyObservers(order);
        } catch (InterruptedException ignored) {

        }
        busy = false;
    }
}
