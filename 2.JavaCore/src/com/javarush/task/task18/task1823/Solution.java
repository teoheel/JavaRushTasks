package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/*
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName;
            while (!(fileName = reader.readLine()).equals("exit")) {
                try {
                    ReadThread readThread = new ReadThread(fileName);
                    readThread.start();
                    readThread.join();
                } catch (FileNotFoundException | InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static class ReadThread extends Thread {
        BufferedInputStream inputStream;
        String file;

        public ReadThread(String fileName) throws FileNotFoundException {
            //implement constructor body
            file = fileName;
            inputStream = new BufferedInputStream(new FileInputStream(fileName));
        }

        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run() {
            int[] bytes = new int[256];
            try {
                while (inputStream.available() > 0) {
                    bytes[inputStream.read()]++;
                }
                inputStream.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            int max = Integer.MIN_VALUE;
            int maxI = Integer.MAX_VALUE;
            for (int i = 0; i < bytes.length; i++) {
                if (bytes[i] > max && bytes[i] > 0) {
                    max = bytes[i];
                    maxI = i;
                }
            }
            resultMap.put(file, maxI);
        }
    }
}
