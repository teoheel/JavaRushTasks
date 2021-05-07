package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private static final LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();
    private static final int ORDER_CREATING_INTERVAL = 100;

    public static void main(String[] args) {
        List<Tablet> tablets = new ArrayList<>();
        Cook jeff = new Cook("Jeff");
        jeff.setQueue(orderQueue);
        Thread jeffThread = new Thread(jeff);
        jeffThread.start();
        Cook john = new Cook("John");
        john.setQueue(orderQueue);
        Thread johnThread = new Thread(john);
        johnThread.start();
        Waiter waiter = new Waiter();
        jeff.addObserver(waiter);
        john.addObserver(waiter);
        for (int i = 1; i <= 5; i++) {
            Tablet tablet = new Tablet(i);
            tablet.setQueue(orderQueue);
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
