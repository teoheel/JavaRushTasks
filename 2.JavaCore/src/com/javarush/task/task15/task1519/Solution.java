package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String string;

        while (!(string = reader.readLine()).equals("exit")) {
            if (string.matches("^[-+]?\\d*\\.\\d+[dD]?$") || string.matches("^[-+]?\\d+\\.\\d*[dD]?$")) {
                print(Double.parseDouble(string));
                continue;
            }
            if (string.matches("^[-+]?\\d+$")) {
                int num = Integer.parseInt(string);
                if (0 < num && num < 128) print((short) num);
                else print(num);
                continue;
            }
            print(string);
        }

        reader.close();
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
