package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        String fileName = args[0];
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder stringBuilder = new StringBuilder();
            while (fileReader.ready()) {
                stringBuilder.append(fileReader.readLine()).append("\n");
            }
            String[] lines = stringBuilder.toString().split("\\n");
            for (String line : lines) {
                String[] temp = line.trim().split("\\s+");
                String name = String.join(" ", Arrays.copyOfRange(temp, 0, temp.length - 3));
                String dateFormat = String.format("%d.%d.%d", Integer.parseInt(temp[temp.length - 3]), Integer.parseInt(temp[temp.length - 2]), Integer.parseInt(temp[temp.length - 1]));
                Date date = new SimpleDateFormat("d.M.yyyy").parse(dateFormat);
                PEOPLE.add(new Person(name, date));
            }
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
    }
}
