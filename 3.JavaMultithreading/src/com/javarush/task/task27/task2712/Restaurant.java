package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;
    private static final StatisticManager STATISTIC_MANAGER = StatisticManager.getInstance();

    public static void main(String[] args) {
        List<Tablet> tablets = new ArrayList<>();
        Cook jeff = new Cook("Jeff");
        Cook john = new Cook("John");
        Waiter waiter = new Waiter();
        jeff.addObserver(waiter);
        john.addObserver(waiter);
        STATISTIC_MANAGER.register(jeff);
        STATISTIC_MANAGER.register(john);
        OrderManager orderManager = new OrderManager();
        for (int i = 1; i <= 5; i++) {
            Tablet tablet = new Tablet(i);
            tablet.addObserver(orderManager);
            tablets.add(tablet);
        }
        Thread thread = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
        thread.start();
        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}
