package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(args[0]);
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            String string = stringBuilder.toString();
            for (int i = 0; i < string.length(); i++) {
                if (alphabet.contains(string.substring(i, i + 1).toLowerCase())) {
                    count++;
                }
            }
            System.out.println(count);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            ex.getStackTrace();
        }
    }
}
