package com.javarush.task.task20.task2026;

/*
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 1},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 3");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 1) {
                    clearRectangle(i, j, a);
                    count++;
                }
            }
        }
        return count;
    }

    static void clearRectangle(int i, int j, byte[][] arr) {
        int n = arr.length;

        // find right bottom corner
        int jRight = 0;
        for (int k = j; k < n; k++) {
            if (arr[i][k] == 0) {
                jRight = k - 1;
                break;
            }
            // if it is the last element
            if (k == n - 1) {
                jRight = k;
            }
        }

        // find right bottom corner
        int iBottom = 0;
        for (int k = i; k < n; k++) {
            if (arr[k][j] == 0) {
                iBottom = k - 1;
                break;
            }
            // if it is last element
            if (k == n - 1) {
                iBottom = k;
            }
        }

        for (int ii = i; ii <= iBottom; ii++) {
            for (int jj = j; jj <= jRight; jj++) {
                arr[ii][jj] = 0;
            }
        }
    }
}
