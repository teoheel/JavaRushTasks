package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;
import java.util.Base64;

public class Solution {
    public static void main(String[] args) {
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(args[1]));
             BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(args[2]))) {
            if (args[0].equals("-d")) {
                byte[] buffer = new byte[inputStream.available()];
                inputStream.read(buffer);
                outputStream.write(Base64.getDecoder().decode(buffer));
            } else if (args[0].equals("-e")) {
                byte[] buffer = new byte[inputStream.available()];
                inputStream.read(buffer);
                outputStream.write(Base64.getEncoder().encode(buffer));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
