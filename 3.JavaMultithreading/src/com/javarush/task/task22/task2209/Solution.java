package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) {
        String[] words = new String[0];
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()))) {
            List<String> strings = new ArrayList<>();
            while (fileReader.ready()) {
                strings.addAll(Arrays.asList(fileReader.readLine().split("\\s+|\\r?\\n+")));
            }
            words = strings.toArray(new String[0]);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if (words.length == 0) {
            return new StringBuilder();
        }

        StringBuilder stringBuilder = new StringBuilder();

        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> tempList = new ArrayList<>();
        for (String word : words) {
            list.add(word);
            recursion(list, tempList, words);
            list.remove(word);
        }

        for (int i = 0; i < tempList.size(); i++) {
            stringBuilder.append(tempList.get(i));
            if (i != tempList.size() - 1) {
                stringBuilder.append(" ");
            }
        }

        return stringBuilder;
    }

    public static void recursion(ArrayList<String> list, ArrayList<String> tempList, String... words) {
        for (String word : words) {
            String last = list.get(list.size() - 1);
            if (!list.contains(word) && Character.toLowerCase(last.charAt(last.length() - 1)) == Character.toLowerCase(word.charAt(0))) {
                list.add(word);
                recursion(list, tempList, words);
                list.remove(word);
            }
        }

        if (tempList.size() < list.size()) {
            tempList.clear();
            tempList.addAll(list);
        }
    }
}