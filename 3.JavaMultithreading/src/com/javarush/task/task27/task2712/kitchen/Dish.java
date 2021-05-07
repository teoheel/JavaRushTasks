package com.javarush.task.task27.task2712.kitchen;

import java.util.concurrent.atomic.AtomicInteger;

public enum Dish {
    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);


    private final int duration;

    Dish(int duration) {
        this.duration = duration;
    }

    public static String allDishesToString() {
        StringBuilder allDishes = new StringBuilder();
        AtomicInteger count = new AtomicInteger();
        for (Dish dish : Dish.values()) {
            allDishes.append(dish).append(count.incrementAndGet() < Dish.values().length ? ", " : "");
        }
        return allDishes.toString();
    }

    public int getDuration() {
        return duration;
    }
}
