package com.javarush.task.task20.task2025;

import java.util.Arrays;
import java.util.TreeSet;

public class Solution {
    private static int number;
    private static int[] digitsMultiSet;
    private static int[] testMultiSet;

    private static TreeSet<Long> results;

    private static long maxPow;
    private static long minPow;
    private static long[][] pows;

    private static void genPows(int number) {
        pows = new long[10][number + 1];
        for (int i = 0; i < pows.length; i++) {
            long p = 1;
            for (int j = 0; j < pows[i].length; j++) {
                pows[i][j] = p;
                p *= i;
            }
        }
    }

    private static boolean check(long pow) {
        if (pow >= maxPow) return false;
        if (pow < minPow) return false;

        for (int i = 0; i < 10; i++) {
            testMultiSet[i] = 0;
        }

        while (pow > 0) {
            int i = (int) (pow % 10);
            testMultiSet[i]++;
            if (testMultiSet[i] > digitsMultiSet[i]) return false;
            pow = pow / 10;
        }

        for (int i = 0; i < 10; i++) {
            if (testMultiSet[i] != digitsMultiSet[i]) return false;
        }

        return true;
    }

    private static void search(int digit, int unused, long pow) {
        if (pow >= maxPow) return;

        if (digit == -1) {
            if (check(pow)) results.add(pow);
            return;
        }

        if (digit == 0) {
            digitsMultiSet[digit] = unused;
            search(digit - 1, 0, pow + unused * pows[digit][number]);
        } else {
            if (pow + unused * pows[digit][number] < minPow) return;

            long p = pow;
            for (int i = 0; i <= unused; i++) {
                digitsMultiSet[digit] = i;
                search(digit - 1, unused - i, p);
                if (i != unused) {
                    p += pows[digit][number];
                }
            }
        }
    }

    public static long[] getNumbers(long N) {
        number = 0;
        results = new TreeSet<>();
        digitsMultiSet = new int[10];
        testMultiSet = new int[10];

        int maxN = (N <= 1) ? 1 : (int) Math.ceil(Math.log10(N));
        genPows(maxN);

        for (number = 1; number <= maxN; number++) {
            minPow = (long) Math.pow(10, number - 1);
            maxPow = (long) Math.pow(10, number);
            search(9, number, 0);
        }

        return results.stream()
                .mapToLong(l -> l)
                .filter(l -> l < N)
                .toArray();
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long[] result = getNumbers(Long.MAX_VALUE);
        long end = System.currentTimeMillis();

        System.out.println("time   = " + (end - start) / 1000d + " s");
        System.out.println("result = " + Arrays.toString(result));
    }
}