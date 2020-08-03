package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {
    public static void main(String[] args) {
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Arrays.sort(array);
        double median;
        int n = array.length;
        if (n > 1) {
            median = n % 2 == 1 ? array[n / 2] : (double) (array[n / 2 - 1] + array[n / 2]) / 2;
            Arrays.sort(array, Comparator.comparingDouble(a -> Math.abs(median - a)));
        }
        return array;
    }
}
