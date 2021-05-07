package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

        while (true) {
            try {
                String text = reader.readLine();
                writer.write(text);
                writer.newLine();
                writer.flush();

                if (text.equals("exit")) {
                    break;
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        writer.close();
    }
}
