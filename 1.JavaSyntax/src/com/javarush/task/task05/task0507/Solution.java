package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double sum = 0;
        int count = 0;

        for (; true; ) {
            String text = reader.readLine();
            if (text.equals("-1")) {
                System.out.println(sum / count);
                break;
            }
            double number = Double.parseDouble(text);
            sum += number;
            count++;
        }
    }
}

