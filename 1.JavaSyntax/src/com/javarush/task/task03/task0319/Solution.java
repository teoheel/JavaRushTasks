package com.javarush.task.task03.task0319;

/* 
Предсказание на будущее
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        int money = Integer.parseInt(reader.readLine());
        int years = Integer.parseInt(reader.readLine());
        System.out.println(name + " получает " + money + " через " + years + " лет.");
    }
}
