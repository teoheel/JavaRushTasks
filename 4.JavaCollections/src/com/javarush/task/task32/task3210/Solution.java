package com.javarush.task.task32.task3210;

/* 
Используем RandomAccessFile
*/

import java.io.IOException;
import java.io.RandomAccessFile;

public class Solution {
    public static void main(String... args) {
        readAndWriteFromExistingFile(args[0], Integer.parseInt(args[1]), args[2]);
    }

    public static void readAndWriteFromExistingFile(String fileName, int number, String text) {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw")) {
            byte[] buffer = new byte[text.length()];
            randomAccessFile.seek(number);
            randomAccessFile.read(buffer, 0, text.length());
            String newText = new String(buffer);
            System.out.println(newText);
            randomAccessFile.seek(randomAccessFile.length());
            randomAccessFile.write(newText.equals(text) ? "true".getBytes() : "false".getBytes());
        } catch (IOException ignored) {
        }
    }
}
