package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        String tempString;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter(reader.readLine()))) {
            while ((tempString = fileReader.readLine()) != null) {
                stringBuilder.append(tempString).append("\n");
            }
            String resultString = stringBuilder.toString().trim();
            String[] strings = resultString.split("\\s");
            for (String string : strings) {
                if (string.matches("\\d+")) {
                    fileWriter.write(string + " ");
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
