package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static com.javarush.task.task27.task2712.ConsoleHelper.getAllDishesForOrder;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        initDishes();
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public Tablet getTablet() {
        return tablet;
    }

    protected void initDishes() throws IOException {
        dishes = getAllDishesForOrder();
    }

    public int getTotalCookingTime() {
        return dishes.stream().mapToInt(Dish::getDuration).sum();
    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder order = new StringBuilder();
        if (!dishes.isEmpty()) {
            order.append("Your order: ");
            AtomicInteger countOfDishes = new AtomicInteger(0);
            for (Dish dish : dishes) {
                order.append(dish).append(countOfDishes.incrementAndGet() < dishes.size() ? ", " : String.format(" of %s", tablet));
            }

        }
        return order.toString();
    }
}
