package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedOutputStream fileOutputStream = new BufferedOutputStream(new FileOutputStream(reader.readLine()))) {
            PrintStream consoleStream = System.out;

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PrintStream stream = new PrintStream(outputStream);
            System.setOut(stream);

            testString.printSomething();

            String result = outputStream.toString();

            System.setOut(consoleStream);

            System.out.println(result);
            fileOutputStream.write(result.getBytes());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

