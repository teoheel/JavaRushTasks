package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        TreeSet<Character> letters = new TreeSet<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(args[0]))) {
            while (fileReader.ready()) {
                String s = fileReader.readLine().toLowerCase();
                for (int i = 0; i < s.length(); i++)
                    letters.add(s.charAt(i));
            }
        }

        letters.stream()
                .filter(Character::isLetter)
                .limit(5)
                .forEach(System.out::print);
    }
}
