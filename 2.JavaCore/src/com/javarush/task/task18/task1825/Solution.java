package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) {
        String fileName;
        ArrayList<String> inputFileNames = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (!(fileName = reader.readLine()).equals("end")) {
                inputFileNames.add(fileName);
            }
            Collections.sort(inputFileNames);
            String outputFileName = inputFileNames.get(0).split("\\.part\\d+$")[0];
            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(outputFileName));
            for (String inputFileName : inputFileNames) {
                BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(inputFileName));
                byte[] buffer = new byte[inputStream.available()];
                int count = inputStream.read(buffer);
                inputStream.close();
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
