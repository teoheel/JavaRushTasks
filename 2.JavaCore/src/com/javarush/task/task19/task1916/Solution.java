package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader1 = new BufferedReader(new FileReader(reader.readLine()));
             BufferedReader fileReader2 = new BufferedReader(new FileReader(reader.readLine()))) {
            String temp;
            List<String> originalList = new ArrayList<>();
            List<String> redactedList = new ArrayList<>();
            while ((temp = fileReader1.readLine()) != null) {
                originalList.add(temp);
            }
            while ((temp = fileReader2.readLine()) != null) {
                redactedList.add(temp);
            }
            while (originalList.size() > 1 || redactedList.size() > 1) {
                if (originalList.get(0).equals(redactedList.get(0))) {
                    lines.add(new LineItem(Type.SAME, originalList.get(0)));
                    originalList.remove(0);
                    redactedList.remove(0);
                } else if (originalList.get(1).equals(redactedList.get(0))) {
                    lines.add(new LineItem(Type.REMOVED, originalList.get(0)));
                    originalList.remove(0);
                } else if (originalList.get(0).equals(redactedList.get(1))) {
                    lines.add(new LineItem(Type.ADDED, redactedList.get(0)));
                    redactedList.remove(0);
                }
            }
            if (originalList.size() == 0) lines.add(new LineItem(Type.ADDED, redactedList.get(0)));
            if (redactedList.size() == 0) lines.add(new LineItem(Type.REMOVED, originalList.get(0)));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
