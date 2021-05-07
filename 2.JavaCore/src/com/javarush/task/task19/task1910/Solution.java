package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String tempString;
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter(reader.readLine()))) {
            while ((tempString = fileReader.readLine()) != null) {
                tempString = tempString.replaceAll("[^\\w\\d\\s]", "");
                stringBuilder.append(tempString).append("\n");
            }
            fileWriter.write(stringBuilder.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
