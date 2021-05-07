package com.javarush.task.task05.task0532;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum = Integer.MIN_VALUE;

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(reader.readLine());
            if (number > maximum) {
                maximum = number;
            }
        }

        //напишите тут ваш код

        System.out.println(maximum);
    }
}
