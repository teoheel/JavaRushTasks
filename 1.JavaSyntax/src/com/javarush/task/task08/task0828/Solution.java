package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Month;
import java.util.ArrayList;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<String> months = new ArrayList<>();
        for (int i = 1; i <= 12; i++)
            months.add(Month.of(i).toString());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String targetMonth = reader.readLine();
        System.out.println(targetMonth + " is " + (months.indexOf(targetMonth.toUpperCase()) + 1) + " month");
    }
}
