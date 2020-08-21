package com.javarush.task.task32.task3201;

import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) {
        writeToExistingFile(args[0], Integer.parseInt(args[1]), args[2]);
    }

    private static void writeToExistingFile(String fileName, int number, String text) {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw")) {
            if (randomAccessFile.length() < number) {
                randomAccessFile.seek(randomAccessFile.length());
            } else {
                randomAccessFile.seek(number);
            }
            randomAccessFile.write(text.getBytes());
        } catch (IOException ignored) {

        }
    }
}
