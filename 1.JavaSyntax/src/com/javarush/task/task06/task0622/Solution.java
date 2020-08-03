package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        int[] ints = new int[5];
        for (int i = 0; i < 5; i++) {
            int integer = Integer.parseInt(reader.readLine());
            ints[i] = integer;
        }

        for (int i = ints.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (ints[j] > ints[j + 1]) {
                    int number = ints[j];
                    ints[j] = ints[j + 1];
                    ints[j + 1] = number;
                }
            }
        }

        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
