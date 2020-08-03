package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream inputStream = new FileInputStream(reader.readLine());
             FileOutputStream outputStream1 = new FileOutputStream(reader.readLine());
             FileOutputStream outputStream2 = new FileOutputStream(reader.readLine())) {
            byte[] buffer2 = new byte[inputStream.available() / 2];
            byte[] buffer1 = new byte[inputStream.available() - buffer2.length];
            inputStream.read(buffer1);
            inputStream.read(buffer2);
            outputStream1.write(buffer1);
            outputStream2.write(buffer2);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
