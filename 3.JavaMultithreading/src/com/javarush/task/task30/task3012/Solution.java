package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(3281);
    }

    public void createExpression(int number) {
        int[] arr = {1, 3, 9, 27, 81, 243, 729, 2187};
        StringBuilder s = new StringBuilder();
        int nn = number;
        while (nn > 0) {
            if (nn % 3 == 0) {
                s.append("0");
                nn /= 3;
            } else if (nn % 3 == 1) {
                s.append("+");
                nn /= 3;
            } else {
                s.append("-");
                nn /= 3;
                nn++;
            }
        }
        StringBuilder str = new StringBuilder();
        if (s.length() <= arr.length) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '+') {
                    str.append(" + ").append(arr[i]);
                } else if (s.charAt(i) == '-') {
                    str.append(" - ").append(arr[i]);
                }
            }
            System.out.printf("%d =%s", number, str + System.lineSeparator());
        }
    }
}