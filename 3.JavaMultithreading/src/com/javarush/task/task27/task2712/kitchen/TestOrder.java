package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class TestOrder extends Order {
    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    @Override
    protected void initDishes() {
        dishes = new ArrayList<>();
        Dish[] values = Dish.values();
        int length = values.length;
        int randomDishes = ThreadLocalRandom.current().nextInt(1, length);
        for (int i = 0; i < randomDishes; i++) {
            int random = (int) (Math.random() * length);
            dishes.add(values[random]);
        }
    }
}
