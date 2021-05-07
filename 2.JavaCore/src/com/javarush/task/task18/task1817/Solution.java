package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;

public class Solution {
    public static void main(String[] args) {
        int spaces = 0;
        int symbols = 0;
        File file = new File(args[0]);
        try (FileInputStream inputStream = new FileInputStream(file)) {
            byte[] bytes = new byte[inputStream.available()];
            symbols = bytes.length;
            inputStream.read(bytes);
            for (byte _byte : bytes) {
                if (_byte == 32) {
                    spaces++;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.print(new DecimalFormat("#0.00").format((double) spaces * 100 / symbols).replace(",", "."));
    }
}
