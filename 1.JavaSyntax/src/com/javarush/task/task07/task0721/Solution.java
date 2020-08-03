package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int maximum = Integer.MIN_VALUE;
        int minimum = Integer.MAX_VALUE;

        //напишите тут ваш код
        int[] ints = new int[20];

        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(reader.readLine());
        }

        for (int j = 0; j < ints.length; j++) {
            if (minimum > ints[j]) {
                minimum = ints[j];
            } else if (maximum < ints[j]) {
                maximum = ints[j];
            }
        }

        System.out.print(maximum + " " + minimum);
    }
}