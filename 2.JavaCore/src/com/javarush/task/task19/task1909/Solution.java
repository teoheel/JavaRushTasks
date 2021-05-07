package com.javarush.task.task19.task1909;

/* 
Замена знаков
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
                stringBuilder.append(tempString).append("\n");
            }
            String result = stringBuilder.toString().replace(".", "!").trim();
            fileWriter.write(result);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
