package com.javarush.task.task36.task3603;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Solution {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.remove("B");
        List<String> collection = Arrays.asList("B", "C", "D", "B");

        list.addAllAbsent(collection);

        list.forEach(System.out::println);
    }
}