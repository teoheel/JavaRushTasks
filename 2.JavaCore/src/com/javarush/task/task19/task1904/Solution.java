package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner scanner) {
            fileScanner = scanner;
        }

        @Override
        public Person read() throws ParseException {
            String result = fileScanner.nextLine();
            String[] data = result.split("\\s", 4);
            Date date = new SimpleDateFormat("d M y", Locale.ENGLISH).parse(data[3]);
            return new Person(data[1], data[2], data[0], date);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
