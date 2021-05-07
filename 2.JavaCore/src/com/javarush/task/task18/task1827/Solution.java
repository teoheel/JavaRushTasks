package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.Arrays;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("-c")) {
            String fileName;
            String string;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                 BufferedWriter outputWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName = reader.readLine(), true)))) {
                int max = Integer.MIN_VALUE;
                int id;
                File file = new File(fileName);
                if (!file.createNewFile()) {
                    BufferedReader inputReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
                    while ((string = inputReader.readLine()) != null) {
                        id = Integer.parseInt(string.substring(0, 8).trim());
                        if (id > max) {
                            max = id;
                        }
                    }
                    inputReader.close();
                }
                String result = String.format(Locale.ENGLISH, "%-8d%-30s%-8.2f%-4d\n", max == Integer.MIN_VALUE ? 1 : max + 1, String.join(" ", Arrays.copyOfRange(args, 1, args.length - 2)), Double.parseDouble(args[args.length - 2]), Integer.parseInt(args[args.length - 1]));
                outputWriter.write(result);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}