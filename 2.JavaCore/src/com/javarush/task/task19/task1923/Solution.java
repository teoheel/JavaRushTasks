package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String fileToRead = args[0];
        String fileToWrite = args[1];
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileToRead));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileToWrite))) {
            List<String> stringList = new ArrayList<>();
            while (fileReader.ready()) {
                stringList.add(fileReader.readLine());
            }
            for (String line : stringList) {
                String[] temp = line.split("\\s+");
                for (String s : temp) {
                    if (s.matches("\\b\\S*\\d+\\S*\\b")) {
                        fileWriter.write(s + " ");
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
