package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String fileToRead = args[0];
        String fileToWrite = args[1];
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileToRead));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileToWrite))) {
            StringBuilder stringBuilder = new StringBuilder();
            while (fileReader.ready()) {
                stringBuilder.append(fileReader.readLine()).append(" ");
            }
            String[] result = stringBuilder.toString().split("\\s");
            StringBuilder resultBuilder = new StringBuilder();
            for (String string : result) {
                if (string.matches("[\\S]{7,}")) {
                    resultBuilder.append(string + ",");
                }
            }
            fileWriter.write(resultBuilder.toString().substring(0, resultBuilder.length() - 1));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
