package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        int count = 0;
        String tempString;
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()))) {
            while ((tempString = fileReader.readLine()) != null) {
                stringBuilder.append(tempString).append("\n");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        String result = stringBuilder.toString();
        String[] strings = result.split("\\W");
        for (String string : strings) {
            if (string.equals("world")) {
                count++;
            }
        }
        System.out.println(count);
    }
}
