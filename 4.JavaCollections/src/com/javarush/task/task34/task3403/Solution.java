package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 1; i <= 10; ) {
            solution.recurse((int) Math.pow(2, i++));
        }
    }

    public void recurse(int n) {
        int a = 2;
        while (a <= n) {
            if (n % a == 0) {
                if (a != n) {
                    System.out.print(a + " ");
                    recurse(n / a);
                } else {
                    System.out.println(a);
                }
                return;
            }
            a++;
        }
    }
}
