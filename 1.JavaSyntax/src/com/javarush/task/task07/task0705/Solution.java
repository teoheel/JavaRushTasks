package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] ints = new int[20];

        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(reader.readLine());
        }

        int[] ints1 = new int[10];
        int[] ints2 = new int[10];

        for (int j = 0; j < ints.length; j++) {
            if (j < ints.length / 2) {
                ints1[j] = ints[j];
            } else {
                ints2[j - ints.length / 2] = ints[j];
                System.out.println(ints2[j - ints.length / 2]);
            }
        }
    }
}
