package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.Arrays;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) {
        if (args.length > 0) {
            String string;
            String fileName;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                 BufferedReader inputReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName = reader.readLine())));
                 BufferedWriter outputWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, true)))) {
                if (args[0].equals("-d")) {
                    while ((string = inputReader.readLine()) != null) {
                        if (Integer.parseInt(string.substring(0, 8).trim()) != Integer.parseInt(args[1])) {
                            String result = String.format("%s\n", string);
                            outputWriter.write(result);
                        }
                    }
                } else if (args[0].equals("-u")) {
                    while ((string = inputReader.readLine()) != null) {
                        if (Integer.parseInt(string.substring(0, 8).trim()) != Integer.parseInt(args[1])) {
                            String result = String.format("%s\n", string);
                            outputWriter.write(result);
                        } else {
                            String result = String.format(Locale.ENGLISH, "%-8d%-30s%-8.2f%-4d\n", Integer.parseInt(args[1]), String.join(" ", Arrays.copyOfRange(args, 2, args.length - 2)), Double.parseDouble(args[args.length - 2]), Integer.parseInt(args[args.length - 1]));
                            outputWriter.write(result);
                        }
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
