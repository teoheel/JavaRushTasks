package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader inputReader = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine()), StandardCharsets.UTF_8))) {
            String tempString;
            while ((tempString = inputReader.readLine()) != null) {
                if (tempString.startsWith(args[0] + " ")) {
                    System.out.println(tempString);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
