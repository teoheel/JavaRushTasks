package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        writeMessage(Dish.allDishesToString());
        writeMessage("Введите название блюда: ");
        List<Dish> dishesForOrder = new ArrayList<>();
        String order = readString();
        while (!order.equals("exit")) {
            try {
                dishesForOrder.add(Dish.valueOf(order));
            } catch (IllegalArgumentException e) {
                writeMessage(String.format("%s отсутствует в меню, пожалуйста выберите другое блюдо", order));
            }
            order = readString();
        }
        return dishesForOrder;
    }
}
