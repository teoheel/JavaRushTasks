package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        String fileName = args[0];
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder stringBuilder = new StringBuilder();
            while (fileReader.ready()) {
                stringBuilder.append(fileReader.readLine()).append("\n");
            }
            String[] result = stringBuilder.toString().split("\\n");
            TreeMap<String, Double> treeMap = new TreeMap<>();
            for (String string : result) {
                String[] temp = string.split("\\s");
                if (treeMap.containsKey(temp[0])) {
                    Double d = treeMap.get(temp[0]);
                    treeMap.put(temp[0], d + Double.parseDouble(temp[1]));
                } else {
                    treeMap.put(temp[0], Double.parseDouble(temp[1]));
                }
            }
            double max = Double.MIN_VALUE;
            for (Map.Entry<String, Double> entry : treeMap.entrySet()) {
                if (entry.getValue() > max) {
                    max = entry.getValue();
                }
            }

            for (Map.Entry<String, Double> entry : treeMap.entrySet()) {
                if (max == entry.getValue()) {
                    System.out.println(entry.getKey());
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
