package com.javarush.task.task39.task3908;

/* 
Возможен ли палиндром?
*/
public class Solution {
    public static void main(String[] args) {

    }

    public static boolean isPalindromePermutation(String s) {
        byte b = 0;
        char[] chr = s.toCharArray();

        for (char aChr : chr) {
            b = (byte) (b ^ aChr);
        }

        if (b == 0){
            return true;
        }

        for (char aChr : chr) {
            if (b == (byte) aChr) {
                return true;
            }
        }
        return false;
    }
}
