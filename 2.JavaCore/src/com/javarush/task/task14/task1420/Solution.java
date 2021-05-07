package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void GCD(int first, int second) {
        while (first != 0 && second != 0) {
            if (first > second) {
                first = first % second;
            } else
                second = second % first;
        }
        System.out.println(first + second);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int first, second;
        while (true) {
            try {
                first = Integer.parseInt(reader.readLine());
                if (first <= 0) {
                    throw new Exception();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                second = Integer.parseInt(reader.readLine());
                if (second <= 0) {
                    throw new Exception();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        GCD(first, second);
    }
}
