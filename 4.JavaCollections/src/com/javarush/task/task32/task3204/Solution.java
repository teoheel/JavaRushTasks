package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        String letters = "abcdefghijklmnopqrstuvwxyz";
        String digits = "1234567890";
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            password.append(letters.charAt((int) (Math.random() * 26)));
        }
        for (int i = 0; i < 2; i++) {
            password.append(digits.charAt((int) (Math.random() * 10)));
        }
        for (int i = 0; i < 2; i++) {
            password.append(letters.toUpperCase().charAt((int) (Math.random() * 26)));
        }

        try {
            output.write(password.toString().getBytes());
        } catch (Exception ignored) {

        }

        return output;
    }
}