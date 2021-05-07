package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()))) {
            StringBuilder stringBuilder = new StringBuilder();
            while (fileReader.ready()) {
                stringBuilder.append(fileReader.readLine()).append("\n");
            }
            String[] lines = stringBuilder.toString().split("\\n");
            for (String line : lines) {
                String[] temp = line.split("\\s+");
                int count = 0;
                List<String> tempList = new ArrayList<>();
                for (String tempString : temp) {
                    if (words.contains(tempString) && !tempList.contains(tempString)) {
                        count++;
                        tempList.add(tempString);
                    }
                }
                if (count == 2) {
                    System.out.println(line);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
