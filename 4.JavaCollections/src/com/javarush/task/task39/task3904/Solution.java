package com.javarush.task.task39.task3904;

import java.util.Map;
import java.util.WeakHashMap;

/*
Лестница
*/
public class Solution {
    private static final int N = 70;
    static Map<Integer, Long> map = new WeakHashMap<>();
    static {
        map.put(0, 1L);
        map.put(1, 1L);
        map.put(2, 2L);
        map.put(3, 4L);
    }

    public static void main(String[] args) {
        System.out.println("The number of possible ascents for " + N + " steps is: " + numberOfPossibleAscents(N));
    }

    public static long numberOfPossibleAscents(int n) {
        if (n < 0) {
            return 0;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            long fibonacciValue = ((numberOfPossibleAscents(n - 3) + numberOfPossibleAscents(n - 2))  + numberOfPossibleAscents(n - 1));
            map.put(n, fibonacciValue);
            return fibonacciValue;
        }
    }
}

