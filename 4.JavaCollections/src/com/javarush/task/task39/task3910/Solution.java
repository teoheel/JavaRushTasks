package com.javarush.task.task39.task3910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
isPowerOfThree
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        System.out.print("Input a integer: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int integer = Integer.parseInt(reader.readLine());
        System.out.printf("Is %d a power of three? %b%s", integer, isPowerOfThree(integer), System.lineSeparator());
    }

    public static boolean isPowerOfThree(int n) {
        return n > 0 && Math.pow(3, (int) (Math.log(n) / Math.log(3))) == n;
    }
}
