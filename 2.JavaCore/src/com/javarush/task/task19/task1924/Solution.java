package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()))) {
            List<String> stringList = new ArrayList<>();
            while (fileReader.ready()) {
                stringList.add(fileReader.readLine());
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (String line : stringList) {
                String[] temp = line.split("\\s");
                for (String s : temp) {
                    try {
                        int i = Integer.parseInt(s);
                        stringBuilder.append(map.getOrDefault(i, s)).append(" ");
                    } catch (NumberFormatException ex) {
                        stringBuilder.append(s).append(" ");
                    }
                }
                stringBuilder.append("\n");
            }
            System.out.println(stringBuilder.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
