package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader inputReader = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())));
             BufferedWriter outputWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(reader.readLine())))) {
            String[] doublesArr = inputReader.readLine().split("\\s");
            for (String s : doublesArr) {
                outputWriter.write(Math.round(Double.parseDouble(s)) + " ");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
