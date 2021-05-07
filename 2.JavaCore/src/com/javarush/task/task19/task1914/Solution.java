package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();

        String result = outputStream.toString().trim();

        System.setOut(consoleStream);

        String[] strings = result.split("\\s");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(result);
        if (strings[1].equals("+")) {
            stringBuilder.append(" ").append(Integer.parseInt(strings[0]) + Integer.parseInt(strings[2]));
        } else if (strings[1].equals("-")) {
            stringBuilder.append(" ").append(Integer.parseInt(strings[0]) - Integer.parseInt(strings[2]));
        } else if (strings[1].equals("*")) {
            stringBuilder.append(" ").append(Integer.parseInt(strings[0]) * Integer.parseInt(strings[2]));
        }

        System.out.println(stringBuilder.toString());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

