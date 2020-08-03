package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int posCount = 0;
        int negCount = 0;

        for (int i = 0; i < 3; i++) {
            int number = Integer.parseInt(reader.readLine());
            if (number > 0) posCount++;
            else if (number < 0) negCount++;
        }

        System.out.println("количество отрицательных чисел: " + negCount + "\nколичество положительных чисел: " + posCount);
    }
}
