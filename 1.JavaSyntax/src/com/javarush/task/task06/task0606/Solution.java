package com.javarush.task.task06.task0606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());

        if (number == 0) even++;
        else {
            for (int i = Math.abs(number); i > 0; i = i / 10) {
                if (i % 2 == 0) even++;
                else odd++;
            }
        }

        System.out.println("Even: " + even + " Odd: " + odd);
    }
}
