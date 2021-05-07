package com.javarush.task.task04.task0442;


/* 
Суммирование
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;

        while (true) {
            String text = reader.readLine();
            int number = Integer.parseInt(text);
            sum += number;
            if (text.equals("-1")) {
                System.out.println(sum);
                break;
            }
        }
    }
}
