package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String file = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                file = reader.readLine();
                FileInputStream inputStream = new FileInputStream(file);
                inputStream.close();
            }
        } catch (FileNotFoundException ex) {
            System.out.println(file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
